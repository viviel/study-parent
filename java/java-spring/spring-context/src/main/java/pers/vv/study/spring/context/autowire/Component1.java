package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Component1 implements InitializingBean {

    @Autowired
    private Component2 component;

    public Component1() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
