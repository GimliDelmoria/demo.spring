package demo.spring.stuff;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        // ComplexProcedure est lazy est n'existe pas encore
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);
        // n'est plus créé car appartient au profile demo
        // et on ne lance pas le programme avec ce profile.
        // on indique aucun profile même en fait
        IComplexProcedure p = context.getBean(IComplexProcedure.class);
        double d = p.work(i1, i2);
        System.out.println(d);
    }
}
