package pers.vv.study.jdk.concurrent.juc;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MutexTest {

    private final Mutex o = new Mutex();

    @Test
    void test1() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(runnable());
        es.submit(runnable());
        Utils.sleep(Integer.MAX_VALUE);
    }

    private Runnable runnable() {
        return () -> {
            o.lock();
            try {
                Utils.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                o.unlock();
            }
        };
    }
}