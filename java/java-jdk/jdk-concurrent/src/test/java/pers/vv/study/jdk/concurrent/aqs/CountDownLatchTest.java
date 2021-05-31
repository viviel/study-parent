package pers.vv.study.jdk.concurrent.aqs;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    private static class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException ignored) {
            } // return;
        }

        void doWork() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void test1() throws InterruptedException {
        int N = 4;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) { // create and start threads
            Utils.cachedThreadPool().submit(new Worker(startSignal, doneSignal));
        }
        startSignal.countDown();      // let all threads proceed
        doneSignal.await();           // wait for all to finish
    }
}
