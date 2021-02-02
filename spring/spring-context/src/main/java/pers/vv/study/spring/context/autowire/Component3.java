package pers.vv.study.spring.context.autowire;

import org.springframework.beans.factory.InitializingBean;

//@Component
public class Component3 implements InitializingBean {

    public Component3(Component4 component) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
