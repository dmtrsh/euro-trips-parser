package sh.parsers.eurotripsparser.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.model.kiwi.SearchParamsUrl;
import sh.parsers.eurotripsparser.model.kiwi.SearchResult;

@Component
public interface KiwiClient {
    ResponseEntity<SearchResult> searchForParams(SearchParamsUrl params);
}
