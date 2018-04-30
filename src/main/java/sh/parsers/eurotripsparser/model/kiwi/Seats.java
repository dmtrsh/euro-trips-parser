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
public class Seats {

    @JsonProperty("infants")
    public Long infants;
    @JsonProperty("passengers")
    public Long passengers;
    @JsonProperty("adults")
    public Long adults;
    @JsonProperty("children")
    public Long children;

}
