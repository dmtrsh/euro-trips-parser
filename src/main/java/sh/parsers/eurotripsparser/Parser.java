package sh.parsers.eurotripsparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.config.Target;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Parser {

    @Autowired
    private Target target;

    public List<Document> parse() {
        return target.getListOfParseUrls()
                .stream()
                .map(it -> {
                    try {
                        return Jsoup.connect(it).get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

}
