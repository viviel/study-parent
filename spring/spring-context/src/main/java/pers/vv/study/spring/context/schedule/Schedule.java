package pers.vv.study.spring.context.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

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
