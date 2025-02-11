package demo.spring.stuff;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // pour que ça passe, cette fois il faut qu'on active le profile demo.
        System.setProperty("spring.profiles.active", "demo"); // pourrait contenir une liste de profiles séparés par des ,

        // notes :
        // Les beans sans profile explicite sont toujours créés !
        // On peut aussi activer des profiles via la variable système -Dspring.profiles.active
        // On utilise aussi l'annotation @ActiveProfiles mais pour les tests uniquement

        // On passe en configurable pour pouvoir accéder à la méthode close
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        DateToken dt = context.getBean(DateToken.class);
        System.out.println(dt.getTime());
        Thread.sleep(1000);
        dt = context.getBean(DateToken.class);
        System.out.println(dt.getTime()); // les deux beans contiennent des moments espacés de 1 seconde environ

        // ComplexProcedure est lazy est n'existe pas encore
        IntStream i1 = IntStream.of(1, 2, 3);
        IntStream i2 = IntStream.of(1, 2, 3);

        IComplexProcedure p = context.getBean(IComplexProcedure.class);
        double d = p.work(i1, i2);
        System.out.println(d);

        // Va permettre d'appeler la méthode predestroy
        // le vérifier dans la console
        context.close();
    }
}
