package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.math.BigInteger;

@Configuration
@ComponentScan("demo.spring.stuff") // inconvénient pour définir bean sur des types importés
@Import(MyPropertySourcesConfig.class)
public class MyConfiguration {

    @Bean(initMethod="negate", destroyMethod="negate")
    BigInteger magicBean() {
        return BigInteger.valueOf(1);
    }

}
