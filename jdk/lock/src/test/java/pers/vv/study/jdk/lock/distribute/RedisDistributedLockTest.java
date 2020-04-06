package pers.vv.study.jdk.lock.distribute;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedisDistributedLockTest {

    private static RedisDistributedLock lock;

    @BeforeAll
    static void init() {
        String lockKey = "test.lockKey";
        lock = new RedisDistributedLock(RedisHelper.instance, lockKey, 1000_10);
    }

    @Test
    void lock() {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

}