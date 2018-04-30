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
public class SearchParams {

    @JsonProperty("to_type")
    public String toType;
    @JsonProperty("flyFrom_type")
    public String flyFromType;
    @JsonProperty("seats")
    public Seats seats;

}
