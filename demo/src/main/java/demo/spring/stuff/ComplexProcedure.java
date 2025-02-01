package demo.spring.stuff;

import java.util.stream.IntStream;

public class ComplexProcedure {

    private final Calculator calculator;
    private final Aggregator aggregator;

    public ComplexProcedure(Calculator calculator, Aggregator aggregator) {
        this.calculator = calculator;
        this.aggregator = aggregator;
    }

    public double work(IntStream i1, IntStream i2) {
        return aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
    }

}
