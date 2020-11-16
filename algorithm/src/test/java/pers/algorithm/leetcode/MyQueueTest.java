package pers.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyQueueTest {

    @Test
    void test1() {
        MyQueue o = new MyQueue();
        o.push(1);
        o.push(2);
        assertEquals(o.peek(), 1);
        assertEquals(o.pop(), 1);
        assertFalse(o.empty());
    }

}
