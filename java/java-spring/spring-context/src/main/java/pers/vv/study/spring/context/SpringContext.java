package pers.vv.study.spring.context;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.vv.study.spring.context.aop.MathCalculator;

public class SpringContext {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "spring/spring-context/target/cglib");
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext("pers.vv.study.spring.context");
        ac.registerShutdownHook();
        SpringContext sc = new SpringContext();
        sc.mathCalculator(ac);
    }

    private void mathCalculator(ApplicationContext ac) {
        MathCalculator bean = ac.getBean(MathCalculator.class);
        bean.div(2, 2);
    }
}
