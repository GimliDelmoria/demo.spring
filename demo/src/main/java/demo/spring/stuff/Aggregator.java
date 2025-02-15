package demo.spring.stuff;

import org.springframework.stereotype.Repository;

@Repository // décompilesr l'annotation pour voir qu'elle ne diffère pas vraiment d'un @Component classique
// on pourrait aussi tout aussi bien définir notre propre annotation dedede
public class Aggregator implements IAggregator {

    @Override
    public double aggregate(double a, double b) {
        return a + b;
    }

}
