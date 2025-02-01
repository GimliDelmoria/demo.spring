package demo.spring.stuff;

import java.util.stream.IntStream;

public class ComplexProcedure {

    private Calculator calculator = new Calculator();
    private Aggregator aggregator = new Aggregator();

    public double work(IntStream i1, IntStream i2) {
        return aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
    }

}
