package demo.spring.stuff;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ComplexProcedure implements IComplexProcedure {

    private ICalculator calculator = null;
    private IAggregator aggregator = null;

    public ComplexProcedure(ICalculator calculator, IAggregator aggregator) {
        this.calculator = calculator;
        this.aggregator = aggregator;
    }

    @Override
    public double work(IntStream i1, IntStream i2) {
        return aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
    }

}
