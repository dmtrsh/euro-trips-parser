package sh.parsers.eurotripsparser.model.kiwi;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchParamsUrl {

    public String flyFrom;
    public String to;
    public LocalDate dateFrom;
    public LocalDate dateTo;
    public String partner;
    public String typeFlight;
    public String directFlights;
    public String curr;
    public String priceTo;
    public LocalDate returnFrom;
    public LocalDate returnTo;
    public String maxstopovers;
    public String returndtimefrom;
    public String returndtimeto;
    public String returnatimefrom;
    public String returnatimeto;

    public String dtimefrom;
    public String dtimeto;
    public String atimefrom;
    public String atimeto;

}
