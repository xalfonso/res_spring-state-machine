import eas.com.config.ProcessDefinitionConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.statemachine.StateMachine;

import java.util.logging.Logger;

public class InitProgram {
    private static final Logger LOG = Logger.getLogger(InitProgram.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProcessDefinitionConf.class);

        StateMachine<String, String> stateMachine = context.getBean("myProcessDefinitionStateMachine", StateMachine.class);
        stateMachine.sendEvent("E1");


    }
}