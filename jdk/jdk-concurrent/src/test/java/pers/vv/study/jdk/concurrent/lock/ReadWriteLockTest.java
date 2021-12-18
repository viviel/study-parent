package pers.vv.study.jdk.concurrent.lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private ReentrantReadWriteLock lock;

    @BeforeEach
    void setUp() {
        lock = new ReentrantReadWriteLock();
    }

    @Test
    void t1() {
        Lock readLock = this.lock.readLock();
        Lock writeLock = this.lock.writeLock();
    }
}
