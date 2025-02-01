package demo.spring.stuff;

public class Aggregator {

    private static Aggregator singleton = new Aggregator();

    private Aggregator() {
    }

    public static Aggregator getInstance() {
        return singleton;
    }

    public double aggregate(double a, double b) {
        return a + b;
    }

}
