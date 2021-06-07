package pers.vv.study.spring.context.aop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = AopTest.Config.class)
class AopTest {

    @EnableAspectJAutoProxy
    static class Config {

        @Bean
        public LogAspects logAspects() {
            return new LogAspects();
        }

        @Bean
        public MathCalculator mathCalculator() {
            return new MathCalculator();
        }
    }

    @Autowired
    private MathCalculator mathCalculator;

    @BeforeAll
    static void beforeAll() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
    }

    @Test
    void test1() {
        int r = mathCalculator.div(2, 1);
    }
}
