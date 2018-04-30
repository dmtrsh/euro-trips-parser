package sh.parsers.eurotripsparser.model.kiwi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {

    @JsonProperty("bags_recheck_required")
    public Boolean bagsRecheckRequired;
    @JsonProperty("mapIdfrom")
    public String mapIdfrom;
    @JsonProperty("flight_no")
    public Long flightNo;
    @JsonProperty("original_return")
    public Long originalReturn;
    @JsonProperty("lngFrom")
    public Double lngFrom;
    @JsonProperty("flyTo")
    public String flyTo;
    @JsonProperty("guarantee")
    public Boolean guarantee;
    @JsonProperty("mapIdto")
    public String mapIdto;
    @JsonProperty("source")
    public String source;
    @JsonProperty("combination_id")
    public String combinationId;
    @JsonProperty("id")
    public String id;
    @JsonProperty("latFrom")
    public Double latFrom;
    @JsonProperty("lngTo")
    public Double lngTo;
    @JsonProperty("aTimeUTC")
    public Long aTimeUTC;
    @JsonProperty("refresh_timestamp")
    public Long refreshTimestamp;
    @JsonProperty("return")
    public Long _return;
    @JsonProperty("price")
    public Long price;
    @JsonProperty("cityTo")
    public String cityTo;
    @JsonProperty("vehicle_type")
    public String vehicleType;
    @JsonProperty("flyFrom")
    public String flyFrom;
    @JsonProperty("dTimeUTC")
    public Long dTimeUTC;
    @JsonProperty("latTo")
    public Double latTo;
    @JsonProperty("dTime")
    public Long dTime;
    @JsonProperty("found_on")
    public String foundOn;
    @JsonProperty("airline")
    public String airline;
    @JsonProperty("cityFrom")
    public String cityFrom;
    @JsonProperty("aTime")
    public Long aTime;

}
