package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaConfiguration {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public Aggregator aggregator() {
        return new Aggregator();
    }

    @Bean
    public ComplexProcedure complexProcedure() {
        return new ComplexProcedure(calculator(), aggregator()); // ne crée pas de nouveaux objets, aggregator et calculator sont bien des singletons.
    }

}
