package demo.spring.stuff;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MaConfiguration.class);
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);
        ComplexProcedure p = context.getBean(ComplexProcedure.class);
        double d = p.work(i1, i2);
        System.out.println(d);
    }
}
