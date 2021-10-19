package pers.vv.study.jdk.concurrent.aqs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private Lock fairLock;

    private Lock unfairLock;

    @BeforeEach
    void setUp() {
        fairLock = new ReentrantLock(true);
        unfairLock = new ReentrantLock();
    }

    @Test
    void test1() {
        unfairLock.lock();
        try {
            System.out.println("locked");
        } finally {
            unfairLock.unlock();
        }
    }

    @Test
    void test2() {
        fairLock.lock();
        try {
            System.out.println("locked");
        } finally {
            fairLock.unlock();
        }
    }
}
