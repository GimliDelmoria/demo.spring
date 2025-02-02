package demo.spring.stuff;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class SupremeCalculator implements ICalculator {

    @Override
    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage() * 2;
    }

}
