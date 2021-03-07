package pers.vv.study.spring.context.schedule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import pers.vv.study.spring.context.SpringConfig;

@Component
public class MSchedule implements InitializingBean {

    @Autowired
    private Test test;

    public MSchedule() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(test.hashCode());
    }

    @Bean
    public TaskScheduler schedule() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(10);
        return executor;
    }

    @Scheduled(fixedDelay = 1)
    public void test1() {
        System.out.println("MSchedule.test1");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 1)
    public void test2() {
        System.out.println("MSchedule.test2");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
