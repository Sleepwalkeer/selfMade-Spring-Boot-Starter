package eu.senla.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@Primary
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "starter-selfmade")
public class StarterSelfMadeProperties {

    private String author;

    private String uri;

    private String dataBase;

}
