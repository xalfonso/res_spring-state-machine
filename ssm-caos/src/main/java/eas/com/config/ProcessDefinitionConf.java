package eas.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Define my state machine process.
 */
@Configuration
@ComponentScan("eas.com")
@EnableStateMachine(name = "myProcessDefinitionStateMachine")
public class ProcessDefinitionConf extends StateMachineConfigurerAdapter<String, String> {

    @Autowired
    private Action<String, String> aToBAction;

    @Autowired
    private Guard<String, String> aToBGuard;

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
        config.withConfiguration().autoStartup(true);
    }


    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
        states.withStates()
                .initial("A")
                .end("C")
                .states(new HashSet<String>(Arrays.asList("A", "B", "C")));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
       transitions
               .withExternal()
               .source("A").target("B").event("E1").action(aToBAction).guard(aToBGuard)
               .and()
               .withExternal()
               .source("B").target("C").event("E2")
               .and()
               .withExternal()
               .source("B").target("C").event("E3");
    }
}