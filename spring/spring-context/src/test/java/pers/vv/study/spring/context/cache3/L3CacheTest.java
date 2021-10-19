package pers.vv.study.spring.context.cache3;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pers.vv.study.spring.context.circular.references.Component1;

public class L3CacheTest {

    @EnableAspectJAutoProxy
    @Configuration
    static class Config {
    }

    @Test
    void test1() {
        String path1 = "pers.vv.study.spring.context.cache3";
        String path2 = "pers.vv.study.spring.context.circular.references";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path1, path2);
        ac.setAllowCircularReferences(true);
        Component1 c = ac.getBean(Component1.class);
        c.m1();
    }
}
