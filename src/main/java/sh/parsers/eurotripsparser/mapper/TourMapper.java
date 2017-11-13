package sh.parsers.eurotripsparser.mapper;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.model.Tour;

@Getter
@Setter
@Component
public class TourMapper {

    public Tour toTour(Document document){
        return Tour.builder()
                .name(getTextByClass(document, "main-title-blue"))
                .url(document.baseUri())
                .price(getPrice(document))
                .places(getTextByClass(document, "active-table"))
                .date(getDate(document))
                .newPrice(getNewPrice(document))
                .newPricePlaces(getNewPricePlaces(document))
                .oldPrice(getTextByClass(document, "old_price"))
                .build();
    }

    private String getTextByClass(Document document, String cssClass){
        return document.getElementsByClass(cssClass).first().text();
    }

    private String getDate(Document document){
        String cssClass = "js-modal-open";
        String td = "td";
        String p = "p";
        return document.getElementsByClass(cssClass).first()
                .getElementsByTag(td).first()
                .getElementsByTag(p).text();
    }
    private String getPrice(Document document){
        String indexTextBlockClass = "index-text-block";
        String priceClass = "price";
        String p = "p";
        return document.getElementsByClass(indexTextBlockClass).first()
                .getElementsByClass(priceClass).first()
                .getElementsByTag(p).text();
    }
    private String getNewPrice(Document document){
        String newPriceClass = "new_price";
        String p = "p";
        return document.getElementsByClass(newPriceClass).first()
                .getElementsByTag(p).text();
    }
    private String getNewPricePlaces(Document document){
        String newPriceClass = "new_price";
        String div = "div";
        String span = "span";
        return document.getElementsByClass(newPriceClass).first()
                .getElementsByTag(div).first()
                .getElementsByTag(span).text();
    }
}
