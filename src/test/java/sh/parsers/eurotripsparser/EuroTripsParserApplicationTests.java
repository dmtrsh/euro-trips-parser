package sh.parsers.eurotripsparser;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sh.parsers.eurotripsparser.mapper.TourMapper;
import sh.parsers.eurotripsparser.model.Tour;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EuroTripsParserApplicationTests {

	@Autowired
	private Parser parser;
	@Autowired
	private TourMapper tourMapper;

	@Test
	public void contextLoads() {

		List<Document> documents = parser.parse();
		List<Tour> tours = documents.stream()
				.map(it -> tourMapper.toTour(it))
				.collect(Collectors.toList());

//		TelegramBot bot = new TelegramBot("458551692:AAHadT7RGf0B7IUywogx8awmbP2vdr4SLgc");
//
//        SendMessage request = new SendMessage(161148392, "text")
//                .parseMode(ParseMode.HTML)
//                .disableWebPagePreview(true)
//                .disableNotification(true)
//                .replyToMessageId(1)
//                .replyMarkup(new ForceReply());
//        SendResponse sendResponse = bot.execute(request);
//        boolean ok = sendResponse.isOk();
//        Message message = sendResponse.message();
		System.out.printf("");
	}
}
