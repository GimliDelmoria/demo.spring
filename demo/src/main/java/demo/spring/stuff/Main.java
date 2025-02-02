package demo.spring.stuff;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // la première ligne donne :
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'demo.spring.stuff.ICalculator' available: expected single matching bean but found 2: classicCalculator,supremeCalculator
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MaConfiguration.class);
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);
        IComplexProcedure p = context.getBean(IComplexProcedure.class);
        // fonctionne aussi :
        // p = context.getBean(ComplexProcedure.class);
        double d = p.work(i1, i2);
        System.out.println(d);
    }
}
