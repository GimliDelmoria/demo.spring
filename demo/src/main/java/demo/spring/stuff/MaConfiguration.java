package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaConfiguration {

    @Bean
    public ICalculator classicCalculator() {
        return new SupremeCalculator();
    }

    @Bean
    public ICalculator supremeCalculator() {
        return new SupremeCalculator();
    }

    @Bean
    public IAggregator aggregator() {
        return new Aggregator();
    }

    @Bean
    public IComplexProcedure complexProcedure(ICalculator calculator, IAggregator aggregator) {
        return new ComplexProcedure(calculator, aggregator); // Le DI conteneur gère tout seul.
    }

}
