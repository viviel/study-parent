package pers.vv.study.spring.context.executor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ExecutorConfig.class)
class TaskExecutorTest {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    void test1() {
//        Utils.block();
    }
}
