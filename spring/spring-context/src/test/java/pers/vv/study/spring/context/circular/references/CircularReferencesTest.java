package pers.vv.study.spring.context.circular.references;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularReferencesTest {

    @Test
    void test1() {
        String path = "pers.vv.study.spring.context.circular.references";
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(path);
        ac.setAllowCircularReferences(true);
        Object c = ac.getBean("component1");
        assertTrue(c instanceof Component1);
    }
}
