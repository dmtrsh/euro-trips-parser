package sh.parsers.eurotripsparser.service;

import com.google.gson.Gson;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.extern.log4j.Log4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.Parser;
import sh.parsers.eurotripsparser.config.TelegramBotConfig;
import sh.parsers.eurotripsparser.mapper.TourMapper;
import sh.parsers.eurotripsparser.model.Tour;
import sh.parsers.eurotripsparser.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Log4j
@Component
public class ParserService {
    @Autowired
    private Parser parser;
    @Autowired
    private TourMapper tourMapper;
    @Autowired
    private Repository repository;
    @Autowired
    private TelegramBotConfig telegramBotConfig;

    @Scheduled(cron = "0 * * * * *")
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

    @Scheduled(cron = "15 40 * * * *")
    public void sendDailyReport(){
        log.info("Sending Daily Report");
        repository.getTours().stream().map(Tour::toMessage).forEach(this::sendMessage);
    }

    private void sendMessage(String message){
        TelegramBot bot = new TelegramBot(telegramBotConfig.getBotId());

        SendMessage request = new SendMessage(telegramBotConfig.getConversationId(), message)
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(false);
        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        Message msg = sendResponse.message();
    }
}
