package pers.vv.study.jdk.concurrent.aqs;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleLock implements Lock {

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            // 获取同步器当前状态
            int state = getState();
            // 获取当前线程
            Thread currentThread = Thread.currentThread();
            // 如果当前同步器状态值为0则说明锁没有被线程占用
            if (state == 0) {
                // 以原子方式更新同步器状态值
                if (compareAndSetState(0, arg)) {
                    // 将锁的独占线程设置为当前线程
                    setExclusiveOwnerThread(currentThread);
                    return true;
                }
            } else if (currentThread == getExclusiveOwnerThread()) {
                // 如果同步器状态值不为0，但当前线程和锁的独占线程是一个线程
                // 则将同步器状态值加1，以允许锁重入
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            boolean released = false;
            Thread currentThread = Thread.currentThread();
            // 如果要释放锁的线程和当前锁的独占线程不是一个线程，则抛出异常
            if (currentThread != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            // 更新同步器状态值
            int state = getState() - arg;
            // 如果同步器状态值为0，则释放锁成功
            if (state == 0) {
                // 清空当前锁的独占线程
                setExclusiveOwnerThread(null);
                released = true;
            }
            // 更新同步器状态值
            setState(state);
            return released;
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, @Nonnull TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Nonnull
    @Override
    public Condition newCondition() {
        return sync.new ConditionObject();
    }
}
