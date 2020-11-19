package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CQueueTest {

    private final CQueue o = new CQueue();

    @Test
    void test1() {
        o.appendTail(5);
        o.appendTail(2);
        assertEquals(5, o.deleteHead());
        assertEquals(2, o.deleteHead());
    }
}