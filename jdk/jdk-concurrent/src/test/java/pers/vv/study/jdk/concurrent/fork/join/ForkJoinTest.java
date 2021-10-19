package pers.vv.study.jdk.concurrent.fork.join;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {

    private ForkJoinPool forkJoinPool;

    @BeforeEach
    void setUp() {
        forkJoinPool = new ForkJoinPool();
    }

    @Test
    void test1() {
        SummationTask task = new SummationTask(0L, 1000000000L);//参数为起始值与结束值
        Long result1 = forkJoinPool.invoke(task);
        Long result2 = forkJoinPool.invoke(task);
        System.out.println(result1);
        System.out.println(result2);
    }
}
