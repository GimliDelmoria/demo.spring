package demo.spring.stuff;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("demo.spring.stuff") // inconvénient pour définir bean sur des types importés
public class MyConfiguration {

}
