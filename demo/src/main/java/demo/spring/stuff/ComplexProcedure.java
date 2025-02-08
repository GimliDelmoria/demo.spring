package demo.spring.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Profile("demo")
@Lazy
/**
 * On place ce bean dans un profile. L'utilisation profile pourrait tout aussi bien
 * être associée à une classe de @Configuration, ou au niveau d'un bean
 */
public class ComplexProcedure implements IComplexProcedure {

    @Autowired
    private ICalculator supremeCalculator = null; // serait ko si le nom du champ ne matchait pas un bean
    @Autowired
    private IAggregator aggregator = null;
    private Limiter limiter = null;

    @Override
    public double work(IntStream i1, IntStream i2) {
        double d = aggregator.aggregate(supremeCalculator.compute(i1), supremeCalculator.compute(i2));
        return limiter != null ? limiter.limit(d) : d;
    }

    // injection par méthode
    // appelée automatiquement à la construction du bean
    @Autowired(required = false) // true est la valeur par défaut
    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }

}
