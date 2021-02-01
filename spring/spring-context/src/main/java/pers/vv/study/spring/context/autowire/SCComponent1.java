package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SCComponent1 implements InitializingBean {

    @Autowired
    private SCComponent2 component;

    public SCComponent1() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
