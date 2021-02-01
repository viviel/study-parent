package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;

//@Component
public class SCComponent4 implements InitializingBean {

    public SCComponent4(SCComponent3 component) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
