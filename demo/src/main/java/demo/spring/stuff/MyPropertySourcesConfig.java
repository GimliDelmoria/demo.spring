package demo.spring.stuff;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("demo") // Avec un autre profile, la configuration ne serait pas trouvée
@PropertySource("classpath:/configuration.properties")
public class MyPropertySourcesConfig {
}
