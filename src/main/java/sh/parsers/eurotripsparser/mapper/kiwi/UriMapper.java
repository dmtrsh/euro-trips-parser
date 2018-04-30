package sh.parsers.eurotripsparser.mapper.kiwi;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.model.kiwi.SearchParamsUrl;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.format.DateTimeFormatter;

@Component
public class UriMapper {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Value("${kiwi.url}")
    private String kiwiUrl;

    public URI toUri(SearchParamsUrl params){
        try {
            return new URIBuilder(kiwiUrl)
                    .addParameter("flyFrom", params.flyFrom)
                    .addParameter("to", params.to)
                    .addParameter("dateFrom", params.dateFrom.format(formatter))
                    .addParameter("dateTo", params.dateTo.format(formatter))
                    .addParameter("partner", params.partner)
                    .addParameter("typeFlight", params.typeFlight)
                    .addParameter("directFlights", params.directFlights)
                    .addParameter("curr", params.curr)
                    .addParameter("price_to", params.priceTo)
                    .addParameter("returnFrom", params.getReturnFrom().format(formatter))
                    .addParameter("returnTo", params.getReturnTo().format(formatter))
                    .addParameter("dtimefrom", params.dtimefrom)
                    .addParameter("returndtimeto", params.returndtimeto)
//                    .addParameter("returnatimeto", params.returnatimeto)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public URL toUrl(SearchParamsUrl params) {
        try {
            return toUri(params).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
