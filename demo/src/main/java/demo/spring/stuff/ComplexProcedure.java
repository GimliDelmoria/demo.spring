package demo.spring.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.IntStream;

@Component
@Profile("demo")
@Lazy
/**
 * On replace notre bean dans le profile demo.
 */
public class ComplexProcedure implements IComplexProcedure {

    @Autowired
    private ICalculator supremeCalculator = null; // serait ko si le nom du champ ne matchait pas un bean
    @Autowired
    private IAggregator aggregator = null;
    private Limiter limiter = null;

    // On ne souhaite pas hardcoder cette valeur
    private Double magicNumber = null;

    /**
     * Spring met à disposition les données de configuration via le bean Environment.
     * Il donne accès aux variables d'environnements et aux variables systèmes qu'il considère comme des
     * sources de données. Equivalent à faire des System.getenv et getProperty Poser un point d'arrêt ligne 33 permet de voir tout ça.
     * @param environment
     */
    public ComplexProcedure(Environment environment) {
        magicNumber = environment.getProperty("magic.number", Double.class);
    }

    @Override
    public double work(IntStream i1, IntStream i2) {
        double d = aggregator.aggregate(supremeCalculator.compute(i1), supremeCalculator.compute(i2));
        if (magicNumber != null && d == magicNumber) {
            System.out.println("So magic");
        }
        return limiter != null ? limiter.limit(d) : d;
    }

    // injection par méthode
    // appelée automatiquement à la construction du bean
    @Autowired // true est la valeur par défaut, mais avec un optional ce n'est plus pareil !
    public void setLimiter(Optional<Limiter> optionalLimiter) {
        // L'exécution va passer par ici mais l'optional sera vide.
        optionalLimiter.ifPresent(l -> {
            this.limiter = l;
        });
    }

}
