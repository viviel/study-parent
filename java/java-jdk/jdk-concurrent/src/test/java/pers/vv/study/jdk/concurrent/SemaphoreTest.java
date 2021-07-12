package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    @Test
    void test1() throws InterruptedException {
        Semaphore s = new Semaphore(2);
        for (int i = 0; i < 2; i++) {
            Utils.cachedThreadPool().execute(() -> {
                try {
                    s.acquire();
                    System.out.println(s.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    s.release();
                }
            });
        }
        s.acquire();
    }
}
