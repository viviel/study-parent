package pers.vv.study.jdk.lock.distribute;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class RedisDistributedLock implements Lock {

    private static final int DEFAULT_REDIS_LOCK_TIMEOUT = 10;//10秒

    private static final int MAX_RETRY_TIMES = 3;

    private static final long PARK_TIME = 200;

    private static final long SPIN_FOR_TIMEOUT_THRESHOLD = 1000L;

    private static final String UNLOCK_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] " +
            "then return redis.call('del', KEYS[1]) " +
            "else return 0 end";

    private int redisLockTimeout = DEFAULT_REDIS_LOCK_TIMEOUT;

    private final Sync sync = new Sync();

    private final UUID uuid = UUID.randomUUID();

    private final String valueFormat = "%d:" + uuid.toString();

    private final RedisHelper redisHelper;

    private final String lockKey;

    public RedisDistributedLock(RedisHelper redisHelper, String lockKey) {
        this.redisHelper = redisHelper;
        this.lockKey = lockKey;
    }

    public RedisDistributedLock(RedisHelper redisHelper, String lockKey, int redisLockTimeout) {
        this.redisHelper = redisHelper;
        this.lockKey = lockKey;
        this.redisLockTimeout = redisLockTimeout;
    }

    public void setRedisLockTimeout(int redisLockTimeout) {
        this.redisLockTimeout = redisLockTimeout;
    }

    @Override
    public void lock() {
        sync.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.unlock();
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    class Sync extends AbstractQueuedSynchronizer {

        final void lock() {
            //在单机服务器内公平
            acquire(1);
        }

        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        @Override
        protected boolean tryAcquire(int acquires) throws AcquireLockTimeoutException {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, 1)
                ) {
                    setExclusiveOwnerThread(current);
                    // 如果是线程被中断失败的话，返回false，如果超时失败的话，捕获异常
                    return tryAcquireRedisLock(TimeUnit.MILLISECONDS.toNanos(redisLockTimeout));
                }
                //可重入
            } else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 不能挂起太久，因为没线程唤醒它,暂时让出时间片
         */
        final boolean parkAndCheckInterrupt() {
            LockSupport.parkNanos(TimeUnit.NANOSECONDS.toNanos(PARK_TIME));
            return Thread.interrupted();
        }

        /**
         * 获取redis锁
         */
        private boolean tryAcquireRedisLock(long nanosTimeout) {
            if (nanosTimeout <= 0L) {
                return false;
            }
            final long deadline = System.nanoTime() + nanosTimeout;
            int retryTimes = 0;
            boolean interrupted = false;

            Jedis jedis = null;
            try {
                jedis = redisHelper.getJedisInstance();
                while (true) {
                    nanosTimeout = deadline - System.nanoTime();
                    if (nanosTimeout <= 0L) {
                        throw new AcquireLockTimeoutException();
                    }
                    String value = String.format(valueFormat, Thread.currentThread().getId());
                    //避免系统宕机锁不释放，设置过期时间
                    if (Objects.equals(jedis.setnx(lockKey, value), 1L)) {
                        jedis.expire(lockKey, redisLockTimeout);

                        //如果线程被中断同时也是失败的
                        return !interrupted;
                    }
                    // 超过尝试次数
                    if (retryTimes > MAX_RETRY_TIMES &&
                        nanosTimeout > SPIN_FOR_TIMEOUT_THRESHOLD &&
                        parkAndCheckInterrupt()
                    ) {
                        interrupted = true;
                    }
                    retryTimes++;
                }
            } finally {
                redisHelper.returnResource(jedis);
            }
        }

        public void unlock() {
            release(1);
        }

        @Override
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                Jedis jedis = null;
                try {
                    jedis = redisHelper.getJedisInstance();
                    String value = String.format(valueFormat, Thread.currentThread().getId());
                    jedis.eval(UNLOCK_SCRIPT, Collections.singletonList(lockKey), Collections.singletonList(value));
                } finally {
                    redisHelper.returnResource(jedis);
                }
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);

            return free;
        }

        @Override
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        final boolean isLocked() {
            return getState() != 0;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }

    }

}