package pers.vv.study.spring.context.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncProcessor {

    @Async
    public void exe() {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }
}
