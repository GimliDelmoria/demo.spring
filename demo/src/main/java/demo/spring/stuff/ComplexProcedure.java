package demo.spring.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ComplexProcedure implements IComplexProcedure {

    // Fonctionne y compris sur les private members, à ne pas privilégier (moins simple après pour les tests)
    @Autowired
    private ICalculator calculator = null;
    @Autowired
    private IAggregator aggregator = null;

    private Limiter limiter = null;

    @Override
    public double work(IntStream i1, IntStream i2) {
        double d = aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
        return limiter != null ? limiter.limit(d) : d;
    }

    // injection par méthode
    // appelée automatiquement à la construction du bean
    @Autowired(required = false) // true est la valeur par défaut
    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }

}
