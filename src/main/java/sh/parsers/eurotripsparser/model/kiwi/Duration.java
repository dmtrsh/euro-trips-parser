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
public class Duration {

    @JsonProperty("total")
    public Long total;
    @JsonProperty("return")
    public Long _return;
    @JsonProperty("departure")
    public Long departure;

}
