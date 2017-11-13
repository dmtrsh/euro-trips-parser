package sh.parsers.eurotripsparser.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Component
@ConfigurationProperties("target")
public class Target {
    private String baseUrl;
    private String parseUrls;

    public List<String> getListOfParseUrls(){
        return Arrays.stream(parseUrls.split(","))
                .map(it -> baseUrl + it)
                .collect(Collectors.toList());
    }
}
