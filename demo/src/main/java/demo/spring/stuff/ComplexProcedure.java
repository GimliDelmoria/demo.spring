package demo.spring.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class ComplexProcedure implements IComplexProcedure {

    private ICalculator calculator = null;
    private IAggregator aggregator = null;
    private Limiter limiter = null;

    @Autowired // pas nécessaire si un seul constructeur (non défaut)
    public ComplexProcedure(ICalculator calculator, IAggregator aggregator) {
        this.calculator = calculator;
        this.aggregator = aggregator;
    }

    public ComplexProcedure(ICalculator calculator, IAggregator aggregator, Limiter limiter) {
        this.calculator = calculator;
        this.limiter = limiter;
        this.aggregator = aggregator;
    }

    @Override
    public double work(IntStream i1, IntStream i2) {
        double d = aggregator.aggregate(calculator.compute(i1), calculator.compute(i2));
        return limiter != null ? limiter.limit(d) : d;
    }

}
