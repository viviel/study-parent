package pers.vv.study.jdk.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierStudy {

    public static void main(String[] args) {

    }

    private void test1() {
        CyclicBarrier barrier = new CyclicBarrier(10);

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
