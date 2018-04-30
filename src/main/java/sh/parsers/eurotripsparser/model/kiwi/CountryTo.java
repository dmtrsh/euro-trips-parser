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
public class CountryTo {

    @JsonProperty("code")
    public String code;
    @JsonProperty("name")
    public String name;

}
