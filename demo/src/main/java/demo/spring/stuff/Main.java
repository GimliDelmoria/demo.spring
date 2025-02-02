package demo.spring.stuff;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);
        IComplexProcedure p = context.getBean(IComplexProcedure.class);
        double d = p.work(i1, i2);
        System.out.println(d);
    }
}
