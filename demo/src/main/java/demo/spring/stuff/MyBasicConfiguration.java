package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBasicConfiguration {

    @Bean
    public ICalculator classicCalculator() {
        return new Calculator();
    }

    @Bean
    public IAggregator aggregator() {
        return new Aggregator();
    }

}
