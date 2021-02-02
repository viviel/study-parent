package pers.vv.study.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContext {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("pers.vv.study.spring.context");
        System.out.println(ac);
    }
}
