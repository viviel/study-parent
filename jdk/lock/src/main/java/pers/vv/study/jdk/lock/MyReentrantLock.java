package pers.vv.study.jdk.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guoshixiong
 */
public class MyReentrantLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(runnable(lock), "thread1").start();
        new Thread(runnable(lock), "thread2").start();
    }

    private static Runnable runnable(Lock lock) {
        return () -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
    }

}
