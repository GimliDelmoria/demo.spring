package demo.spring.stuff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyBasicConfiguration.class) // ou liste entre { }
public class MyConfiguration {

    @Bean
    public IComplexProcedure complexProcedure(ICalculator calculator, IAggregator aggregator) {
        return new ComplexProcedure(calculator, aggregator); // Le DI conteneur gère tout seul.
    }

}
