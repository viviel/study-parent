package pers.vv.study.jdk.concurrent;

import java.util.concurrent.CountDownLatch;

public class LatchStudy {

    public static void main(String[] args) {
        new LatchStudy().test1();
    }

    private void test1() {
        CountDownLatch latch = new CountDownLatch(10);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

}
