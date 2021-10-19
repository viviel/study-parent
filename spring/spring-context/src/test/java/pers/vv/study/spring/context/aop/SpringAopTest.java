package pers.vv.study.spring.context.aop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

class SpringAopTest {

    @BeforeAll
    static void beforeAll() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
    }

    @EnableAspectJAutoProxy
    @Configuration
    static class Config {
    }

    @Test
    void test1() {
        String path = "pers.vv.study.spring.context.aop";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path);
        MathCalculator bean = ac.getBean(MathCalculator.class);
    }
}
