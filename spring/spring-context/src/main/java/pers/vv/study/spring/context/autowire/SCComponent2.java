package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SCComponent2 implements InitializingBean {

    @Autowired
    private SCComponent1 component;

    public SCComponent2() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
