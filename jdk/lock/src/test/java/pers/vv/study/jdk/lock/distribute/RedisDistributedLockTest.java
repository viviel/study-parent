package pers.vv.study.jdk.lock.distribute;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedisDistributedLockTest {

    private final String lockKey = "test.lockKey";

    private RedisDistributedLock lock;

    @BeforeAll
    void init() {
        lock = new RedisDistributedLock(RedisHelper.instance, lockKey);
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