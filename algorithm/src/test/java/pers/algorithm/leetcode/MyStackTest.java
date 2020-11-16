package pers.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyStackTest {

    @Test
    void test1() {
        MyStack o = new MyStack();
        o.push(-2);
        o.push(0);
        o.push(-3);
        assertEquals(o.pop(), -3);
        assertEquals(o.top(), 0);
        assertFalse(o.empty());
        assertEquals(o.pop(), 0);
        assertEquals(o.pop(), -2);
        assertTrue(o.empty());
    }

}