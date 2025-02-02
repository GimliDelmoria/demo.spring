package demo.spring.stuff;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component // annotations de bases
public class Calculator implements ICalculator {

    @Override
    public double compute(IntStream intStream) {
        return intStream.summaryStatistics().getAverage();
    }

}
