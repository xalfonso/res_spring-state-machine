package eas.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;

import java.util.logging.Logger;

/**
 * Define a guards for my process state machine.
 */
@Configuration
public class Guards {

    private static final Logger LOG = Logger.getLogger(Guards.class.getName());

    @Bean
    public Guard<String, String> aToBGuard() {
        return new Guard<String, String>() {
            @Override
            public boolean evaluate(StateContext<String, String> context) {
                LOG.info("Ejecutando la guarda en la transicion del estado A a B");
                return false;
            }
        };
    }
}