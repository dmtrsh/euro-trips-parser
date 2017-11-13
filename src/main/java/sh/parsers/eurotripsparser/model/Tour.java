package sh.parsers.eurotripsparser.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tour {
    private String name;
    private String url;
    private String price;
    private String places;
    private String date;
    private String newPrice;
    private String newPricePlaces;
    private String oldPrice;

    public String toMessage(){
        return "Tour: " + this.name + "\n" +
                "Price: " + this.price + "\n" +
                "Places: " + this.places + "\n" +
                "Date: " + this.date + "\n" +
                "New Price: " + this.newPrice + "\n" +
                "New Price Places: " + this.newPricePlaces + "\n" +
                "Old Price: " + this.oldPrice + "\n" +
                "URL: " + this.url;
    }
}
