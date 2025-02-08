package demo.spring.stuff;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("demo.spring.stuff") // inconvénient pour définir bean sur des types importés
@Import(MyPropertySourcesConfig.class)
public class MyConfiguration {

}
