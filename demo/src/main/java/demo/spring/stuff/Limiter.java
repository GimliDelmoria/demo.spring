package demo.spring.stuff;

import org.springframework.stereotype.Component;

@Component
public class Limiter {

    public double limit(double a) {
        return a > 1000 ? 1000 : a;
    }

}
