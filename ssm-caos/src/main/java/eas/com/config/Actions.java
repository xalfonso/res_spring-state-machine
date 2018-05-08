package eas.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

import java.util.logging.Logger;

/**
 * Define a actions for my process state machine.
 */
@Configuration
public class Actions {

    private static final Logger LOG = Logger.getLogger(Actions.class.getName());

    @Bean
    public Action<String, String> aToBAction() {
        return new Action<String, String>() {
            @Override
            public void execute(StateContext<String, String> context) {
                LOG.info("Ejecutando accion en la transicion del estado A a B");
            }
        };
    }
}
