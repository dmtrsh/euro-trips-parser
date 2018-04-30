package sh.parsers.eurotripsparser.config;

import com.pengrad.telegrambot.TelegramBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


@Getter
@Setter
@Component
@Scope("prototype")
@ConfigurationProperties("telegram.bot")
public class TelegramBotConfig {
    private String botId;
    private Long conversationId;

    @Bean
    public TelegramBot telegramBot(){
        return new TelegramBot(botId);
    }
}
