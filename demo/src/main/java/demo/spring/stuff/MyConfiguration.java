package demo.spring.stuff;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("demo.spring.stuff") // inconvénient pour définir bean sur des types importés
@PropertySource("classpath:/configuration.properties")
// @PropertySource("classpath:configuration.properties") - équivalent
// @PropertySource("file:demo/src/main/resources/configuration.properties") - équivalent avec un chemin relatif (pourrait être absolu)
public class MyConfiguration {

}
