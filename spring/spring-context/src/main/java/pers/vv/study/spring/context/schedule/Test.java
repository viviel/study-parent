package pers.vv.study.spring.context.schedule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test implements InitializingBean {

    @Autowired
    private MSchedule mSchedule;

    public Test() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(mSchedule.hashCode());
    }
}
