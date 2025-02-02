package demo.spring.stuff;

import java.util.stream.IntStream;

public class ComplexProcedure implements IComplexProcedure {

    private final ICalculator calculator;
    private final IAggregator aggregator;

    public ComplexProcedure(ICalculator calculator, IAggregator aggregator) {
        this.calculator = calculator;
        this.aggregator = aggregator;
    }

    @Override
    public double work(IntStream i1, IntStream i2) {
        return aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
    }

}
