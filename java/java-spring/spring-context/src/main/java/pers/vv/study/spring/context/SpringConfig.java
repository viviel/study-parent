package pers.vv.study.spring.context;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@EnableScheduling
@EnableAspectJAutoProxy
@Configuration
public class SpringConfig implements InitializingBean {

    @Autowired
    private List<DisposableBean> disposableBeans;

    @Override
    public void afterPropertiesSet() throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (DisposableBean disposableBean : disposableBeans) {
                try {
                    disposableBean.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
