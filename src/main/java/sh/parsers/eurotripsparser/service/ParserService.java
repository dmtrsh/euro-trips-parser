package sh.parsers.eurotripsparser.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.extern.log4j.Log4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.Parser;
import sh.parsers.eurotripsparser.client.KiwiClient;
import sh.parsers.eurotripsparser.config.TelegramBotConfig;
import sh.parsers.eurotripsparser.mapper.TourMapper;
import sh.parsers.eurotripsparser.mapper.kiwi.MessageMapper;
import sh.parsers.eurotripsparser.model.Tour;
import sh.parsers.eurotripsparser.model.kiwi.SearchParamsUrl;
import sh.parsers.eurotripsparser.model.kiwi.SearchResult;
import sh.parsers.eurotripsparser.repository.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.temporal.TemporalAdjusters.next;

@Log4j
@Component
public class ParserService {
    @Autowired
    private Parser parser;
    @Autowired
    private TourMapper tourMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private Repository repository;
    @Autowired
    private TelegramBotConfig telegramBotConfig;
    @Autowired
    private KiwiClient kiwiClient;
    @Autowired
    private TelegramBot telegramBot;

//    @Scheduled(cron = "0 * * * * *")
    public void parse(){
        List<Document> documents = parser.parse();
        List<Tour> tours = documents.stream()
                .map(it -> tourMapper.toTour(it))
                .collect(Collectors.toList());
        checkToursStatus(tours);
    }

    private void checkToursStatus(List<Tour> tours) {
        log.info("Checking Tours");
        if (!Optional.ofNullable(repository.getTours()).orElse(newArrayList()).containsAll(tours))
            tours.stream().map(Tour::toMessage).forEach(this::sendMessage);
        else log.info("Checking Tours: Nothing was changed.");
        repository.setTours(tours);
    }

//    @Scheduled(cron = "15 40 * * * *")
    public void sendDailyReport(){
        log.info("Sending Daily Report");
        repository.getTours().stream().map(Tour::toMessage).forEach(this::sendMessage);
    }

    private void sendMessage(String message){
        log.info("Sending message");

        SendMessage request = new SendMessage(telegramBotConfig.getConversationId(), message)
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(false);
        SendResponse sendResponse = telegramBot.execute(request);
        boolean ok = sendResponse.isOk();
        if (ok) {
            Message msg = sendResponse.message();
            log.info("Message has been sent.");
        } else {
            log.error("Message hasn't been sent.");
        }
    }

//    @Scheduled(cron = "0 5 9,14,19 * * *")
    @Scheduled(cron = "0 * * * * *")
    public void findFlights(){
        Long weeks = 50L;
        for (int i = 0; i < weeks; i++) {
            AtomicBoolean isNonEmptyWeek = new AtomicBoolean(true);
            LocalDate targetWeek = LocalDate.now().plusWeeks(i);
            LocalDate targetFriday = targetWeek.with(next(FRIDAY));
            LocalDate targetMonday = targetWeek.with(next(MONDAY));
            log.info("WEEK #" + i + ": from " + targetFriday + " to " + targetMonday);
            SearchParamsUrl params = SearchParamsUrl.builder()
                    .flyFrom("KBP,IEV")
                    .to("")
                    .dateFrom(targetFriday)
                    .dateTo(targetFriday)
                    .curr("EUR")
                    .directFlights("1")
                    .priceTo("150")
                    .typeFlight("round")
                    .returnFrom(targetMonday)
                    .returnTo(targetMonday)
                    .maxstopovers("0")
                    .dtimefrom("18:00")
                    .returnatimeto("11:00")
                    .build();

            ResponseEntity<SearchResult> result = kiwiClient.searchForParams(params);
            int finalI = i;
            Optional.ofNullable(result.getBody().getData())
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(d -> !Arrays.asList("UA", "RU", "BY", "TR").contains(d.getCountryTo().code))
                    .filter(d -> !Arrays.asList("Warsaw", "Vilnius", "Ankara", "London", "Vienna", "Stockholm", "Tbilisi", "Riga").contains(d.getCityTo()))
                    .filter(d -> fromEpochMilli(d.getRoute().get(0).dTime * 1000).getHour() >= 18
                                    && fromEpochMilli(d.getRoute().get(1).aTime * 1000).getHour() <= 11
                                    && fromEpochMilli(d.getRoute().get(1).aTime * 1000).getDayOfWeek() == MONDAY)
                    .forEach(d ->{
                        String msg = messageMapper.toMessage(d);
                        if (isNonEmptyWeek.get())
                            sendMessage(String.format("=== WEEK #%s ===", finalI));
                        isNonEmptyWeek.set(false);
                        this.sendMessage(msg);
                    });
        }
        System.out.println();
    }

    private LocalDateTime fromEpochMilli(long epochMilli){
        return Instant.ofEpochMilli(epochMilli).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
