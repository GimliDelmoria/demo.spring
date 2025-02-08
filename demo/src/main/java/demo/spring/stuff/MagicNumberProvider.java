package demo.spring.stuff;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class MagicNumberProvider {

    public Double generateMagicNumber() {
        return new SecureRandom().nextDouble();
    }

}
