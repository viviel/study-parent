package pers.vv.study.spring.context.aop;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MathCalculator implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
    }

    public int div(int i, int j) {
        System.out.println("MathCalculator...div...");
        return i / j;
    }
}
