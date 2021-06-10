package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.*;

public class ExecutorTest {

    @Test
    void test1() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(() -> {
            Utils.sleep(1000 * 10);
            System.out.println("done");
        });
        es.shutdown();
        es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Test
    void test2() throws InterruptedException {
        ThreadPoolExecutor es = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );
        es.execute(() -> {
            Utils.sleep(1000 * 10);
            System.out.println("done");
        });
        es.shutdown();
        es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Test
    void test3() {
        ThreadPoolExecutor es = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );
        es.shutdown();
        es.shutdownNow();
    }

    @Test
    void test4() throws InterruptedException {
        ThreadPoolExecutor es = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE,
                5L, TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );
        es.execute(new Thread(() -> System.out.println(Thread.currentThread())));
        es.execute(() -> System.out.println(Thread.currentThread()));
        es.shutdown();
        es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }
}
