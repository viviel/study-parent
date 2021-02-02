package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;

//@Component
public class Component4 implements InitializingBean {

    public Component4(Component3 component) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
