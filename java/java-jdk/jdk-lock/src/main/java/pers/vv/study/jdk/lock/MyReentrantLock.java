package pers.vv.study.jdk.lock;

import pers.vv.study.common.Utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guoshixiong
 */
public class MyReentrantLock {

    public static void main(String[] args) {
        MyReentrantLock m = new MyReentrantLock();
        m.lock();
    }

    private void lock() {
        Lock lock = new ReentrantLock();
        Utils.cachedThreadPool().submit(runnable(lock));
        Utils.cachedThreadPool().submit(runnable(lock));
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
        Utils.cachedThreadPool().submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Utils.cachedThreadPool().submit(() -> {
            try {
                condition.await();
                System.out.println("thread2 down");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
