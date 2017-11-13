package sh.parsers.eurotripsparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EuroTripsParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuroTripsParserApplication.class, args);
	}
}
