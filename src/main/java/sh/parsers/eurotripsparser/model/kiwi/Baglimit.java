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
public class Baglimit {

    @JsonProperty("hand_width")
    public Long handWidth;
    @JsonProperty("hand_length")
    public Long handLength;
    @JsonProperty("hold_weight")
    public Long holdWeight;
    @JsonProperty("hand_height")
    public Long handHeight;
    @JsonProperty("hand_weight")
    public Long handWeight;

}
