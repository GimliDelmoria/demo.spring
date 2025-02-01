package demo.spring.stuff;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);
        Calculator c = new Calculator();
        Aggregator a = new Aggregator();
        ComplexProcedure p = new ComplexProcedure(c, a);
        double d = p.work(i1, i2);
        System.out.println(d);
    }
}
