package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;

//@Component
public class SCComponent3 implements InitializingBean {

    public SCComponent3(SCComponent4 component) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
