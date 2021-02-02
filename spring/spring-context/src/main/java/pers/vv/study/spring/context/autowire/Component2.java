package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Component2 implements InitializingBean {

    @Autowired
    private Component1 component;

    public Component2() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
