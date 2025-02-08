package demo.spring.stuff;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
/**
 * Il existe d'autres scope dans spring (session et request dans un contexte web, web socket, thread, etc.) mais il est
 * également possible de créer ses propres scopes.
 */
public final class DateToken {

    private LocalDateTime time = LocalDateTime.now();

    public LocalDateTime getTime() {
        return time;
    }

}
