package demo.spring.stuff;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MaConfiguration.class);
        ICalculator c = (ICalculator) context.getBean("classicCalculator"); // Est un Calculator simple
        c = context.getBean("supremeCalculator", ICalculator.class); // Est un Calculator supreme
        c = context.getBean(ICalculator.class); // No qualifying bean of type 'demo.spring.stuff.ICalculator'

    }
}
