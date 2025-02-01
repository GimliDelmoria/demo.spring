package demo.spring.stuff;

import java.util.stream.IntStream;

public class Calculator {

    private static Calculator singleton = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return singleton;
    }

    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage();
    }

}
