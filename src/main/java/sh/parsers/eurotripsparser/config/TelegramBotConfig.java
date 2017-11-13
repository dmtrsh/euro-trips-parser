package sh.parsers.eurotripsparser.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("telegram.bot")
public class TelegramBotConfig {
    private String botId;
    private Long conversationId;
}
