package pers.vv.study.spring.context.autowire;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAutowireTest {

    @Test
    void test1() {
        String path = "pers.vv.study.spring.context.autowire.empty";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path);
        ac.register(Component5.class);
        ac.register(Component6.class);
    }

    @Test
    void test2() {
        String path = "pers.vv.study.spring.context.autowire.empty";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path);
        ConfigurableListableBeanFactory bf = ac.getBeanFactory();
        bf.createBean(Component5.class);
        bf.autowire(Component5.class, 1, true);
    }
}
