package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
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

    @Test
    void test2() {
        Queue<Integer> q = new LinkedList<>();
        Semaphore mutex = new Semaphore(1);
        Semaphore empty = new Semaphore(100);
        Semaphore full = new Semaphore(0);
        Utils.cachedThreadPool().execute(() -> {
            while (!Thread.interrupted()) {
                Random random = new Random();
                int i = random.nextInt(1000);
                empty.acquireUninterruptibly();
                mutex.acquireUninterruptibly();
                q.add(i);
                mutex.release();
                full.release();
            }
        });
        Utils.cachedThreadPool().execute(() -> {
            while (!Thread.interrupted()) {
                full.acquireUninterruptibly();
                mutex.acquireUninterruptibly();
                Integer poll = q.poll();
                System.out.println(poll);
                mutex.release();
                empty.release();
            }
        });
        Utils.block();
    }
}
