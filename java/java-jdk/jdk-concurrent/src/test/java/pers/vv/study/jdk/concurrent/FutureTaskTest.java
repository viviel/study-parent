package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 原理：
 * 通过 FutureTask 内部状态 state 判断任务是否完成。
 * 调用 futureTask.get() 方法时，若任务没有完成，则将线程加入到等待队列 waiters 并通过通过 LockSupport.park() 方法阻塞线程
 */
public class FutureTaskTest {

    @Test
    void test1() throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            Utils.sleep(1000 * 2);
            return 2;
        });
        ft.get();
    }
}
