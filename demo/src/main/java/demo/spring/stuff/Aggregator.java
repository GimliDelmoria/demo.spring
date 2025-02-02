package demo.spring.stuff;

public class Aggregator implements IAggregator {

    @Override
    public double aggregate(double a, double b) {
        return a + b;
    }

}
