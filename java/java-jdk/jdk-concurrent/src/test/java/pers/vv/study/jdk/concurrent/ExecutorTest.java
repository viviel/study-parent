package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.*;

public class ExecutorTest {

    @Test
    void test1() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(() -> {
            try {
                Utils.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        });
        es.shutdown();
        es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Test
    void test2() throws InterruptedException {
        ThreadPoolExecutor es = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>()
        );
        es.execute(() -> {
            try {
                Utils.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        });
        es.shutdown();
        es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }
}
