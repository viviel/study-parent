package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueTest {

    @Test
    void test1() throws InterruptedException {
        LinkedBlockingQueue<Integer> bq = new LinkedBlockingQueue<>(1);
        bq.offer(1);
        bq.put(2);
        Integer r = bq.take();
    }

    @Test
    void test2() throws InterruptedException {
        ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<>(2);
        bq.offer(1);
        bq.put(2);
        Integer r = bq.take();
    }

    @Test
    void test3() throws InterruptedException {
        PriorityBlockingQueue<Integer> bq = new PriorityBlockingQueue<>();
        bq.offer(1);
        bq.put(2);
        Integer r = bq.take();
    }
}
