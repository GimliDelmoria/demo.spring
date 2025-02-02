package demo.spring.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ComplexProcedure implements IComplexProcedure {

    private ICalculator calculator = null;
    private IAggregator aggregator = null;
    private Limiter limiter = null;

    // problème à la création car deux beans candidats
    // on n'avait pas d'erreur avec autowired niveau fields
    public ComplexProcedure(@Qualifier("coolCalculator") ICalculator calculator, IAggregator aggregator) {
        this.calculator = calculator;
        this.aggregator = aggregator;
    }

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
