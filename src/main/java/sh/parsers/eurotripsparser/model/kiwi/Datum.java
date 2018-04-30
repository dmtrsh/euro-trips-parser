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
public class Datum {

    @JsonProperty("aTimeUTC")
    public Long aTimeUTC;
    @JsonProperty("mapIdfrom")
    public String mapIdfrom;
    @JsonProperty("has_airport_change")
    public Boolean hasAirportChange;
    @JsonProperty("p3")
    public Long p3;
    @JsonProperty("type_flights")
    public List<String> typeFlights;
    @JsonProperty("price")
    public Long price;
    @JsonProperty("distance")
    public Double distance;
    @JsonProperty("conversion")
    public Conversion conversion;
    @JsonProperty("bags_price")
    public BagsPrice bagsPrice;
    @JsonProperty("cityTo")
    public String cityTo;
    @JsonProperty("transfers")
    public List<Object> transfers;
    @JsonProperty("flyFrom")
    public String flyFrom;
    @JsonProperty("id")
    public String id;
    @JsonProperty("duration")
    public Duration duration;
    @JsonProperty("dTimeUTC")
    public Long dTimeUTC;
    @JsonProperty("p2")
    public Long p2;
    @JsonProperty("countryFrom")
    public CountryFrom countryFrom;
    @JsonProperty("p1")
    public Long p1;
    @JsonProperty("deep_link")
    public String deepLink;
    @JsonProperty("mapIdto")
    public String mapIdto;
    @JsonProperty("nightsInDest")
    public Object nightsInDest;
    @JsonProperty("dTime")
    public Long dTime;
    @JsonProperty("found_on")
    public List<String> foundOn;
    @JsonProperty("airlines")
    public List<String> airlines;
    @JsonProperty("booking_token")
    public String bookingToken;
    @JsonProperty("flyTo")
    public String flyTo;
    @JsonProperty("pnr_count")
    public Long pnrCount;
    @JsonProperty("fly_duration")
    public String flyDuration;
    @JsonProperty("facilitated_booking_available")
    public Boolean facilitatedBookingAvailable;
    @JsonProperty("routes")
    public List<List<String>> routes;
    @JsonProperty("cityFrom")
    public String cityFrom;
    @JsonProperty("aTime")
    public Long aTime;
    @JsonProperty("countryTo")
    public CountryTo countryTo;
    @JsonProperty("route")
    public List<Route> route;
    @JsonProperty("baglimit")
    public Baglimit baglimit;

}
