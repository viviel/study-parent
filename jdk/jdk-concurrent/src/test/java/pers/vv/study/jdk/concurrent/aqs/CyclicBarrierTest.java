package pers.vv.study.jdk.concurrent.aqs;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    @Test
    void test1() {
        CyclicBarrier cb = new CyclicBarrier(2);
        Utils.cachedThreadPool().execute(() -> {
            Utils.sleep(1000);
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        Utils.cachedThreadPool().execute(() -> {
            Utils.sleep(1000 * 2);
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        Utils.block();
    }
}
