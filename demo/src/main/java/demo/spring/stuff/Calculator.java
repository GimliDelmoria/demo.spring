package demo.spring.stuff;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component // annotations de bases
@Scope("singleton")
/*
  Scope singleton totalement utile car un bean est par défaut un singleton, attention à la problématique du thread safe
  Multi-threading à gérer en classic java (synchronized, immutabilité, stateless, etc.)
*/
public class Calculator implements ICalculator {

    @Override
    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage();
    }

}
