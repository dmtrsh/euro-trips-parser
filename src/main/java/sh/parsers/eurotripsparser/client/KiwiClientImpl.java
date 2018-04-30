package sh.parsers.eurotripsparser.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sh.parsers.eurotripsparser.mapper.kiwi.UriMapper;
import sh.parsers.eurotripsparser.model.kiwi.SearchParamsUrl;
import sh.parsers.eurotripsparser.model.kiwi.SearchResult;

@Component
public class KiwiClientImpl implements KiwiClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UriMapper uriMapper;

    @Override
    public ResponseEntity<SearchResult> searchForParams(SearchParamsUrl params) {
        return restTemplate.getForEntity(uriMapper.toUri(params), SearchResult.class);
    }
}
