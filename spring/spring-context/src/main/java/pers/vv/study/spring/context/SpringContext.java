package pers.vv.study.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class SpringContext {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("pers.vv.study.spring.context");
        Map<String, Converter> map = ac.getBeansOfType(Converter.class);
        System.out.println(map);
    }

}
