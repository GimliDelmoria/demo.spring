package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaConfiguration {

    @Bean
    public ICalculator calculator() {
        return new SupremeCalculator();
    }

    @Bean
    public IAggregator aggregator() {
        return new Aggregator();
    }

    @Bean
    public IComplexProcedure complexProcedure() {
        return new ComplexProcedure(calculator(), aggregator()); // ne crée pas de nouveaux objets, aggregator et calculator sont bien des singletons.
    }

}
