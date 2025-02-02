package demo.spring.stuff;

import org.springframework.stereotype.Component;

@Component
public class Aggregator implements IAggregator {

    @Override
    public double aggregate(double a, double b) {
        return a + b;
    }

}
