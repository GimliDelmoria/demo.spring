package demo.spring.stuff;

import java.util.stream.IntStream;

public class Calculator implements ICalculator {

    @Override
    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage();
    }

}
