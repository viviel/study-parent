package pers.vv.study.jdk.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guoshixiong
 */
public class MyReentrantLock {

    public static void main(String[] args) {
        new MyReentrantLock().condition();
    }

    private void lock() {
        Lock lock = new ReentrantLock();
        new Thread(runnable(lock), "thread1").start();
        new Thread(runnable(lock), "thread2").start();
    }

    private Runnable runnable(Lock lock) {
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

    private void condition() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1").start();
        new Thread(() -> {
            try {
                condition.await();
                System.out.println("thread2 down");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();
    }

}
