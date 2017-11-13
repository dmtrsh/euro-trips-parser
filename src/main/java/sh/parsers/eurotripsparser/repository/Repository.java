package sh.parsers.eurotripsparser.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import sh.parsers.eurotripsparser.model.Tour;

import java.util.List;

@Getter
@Setter
@Component
public class Repository {
    private List<Tour> tours;
}
