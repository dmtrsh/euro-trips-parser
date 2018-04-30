package sh.parsers.eurotripsparser.model.kiwi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResult {

    @JsonProperty("search_params")
    public SearchParams searchParams;
    @JsonProperty("connections")
    public List<Object> connections;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("currency_rate")
    public Long currencyRate;
    @JsonProperty("all_stopover_airports")
    public List<Object> allStopoverAirports;
    @JsonProperty("data")
    public List<Datum> data;
    @JsonProperty("ref_tasks")
    public List<Object> refTasks;
    @JsonProperty("refresh")
    public List<Object> refresh;
    @JsonProperty("del")
    public Object del;
    @JsonProperty("all_airlines")
    public List<Object> allAirlines;
    @JsonProperty("time")
    public Long time;

}
