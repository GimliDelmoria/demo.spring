package demo.spring.stuff;

import java.util.stream.IntStream;

public class Calculator {

    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage();
    }

}
