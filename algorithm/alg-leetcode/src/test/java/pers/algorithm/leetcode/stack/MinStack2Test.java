package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStack2Test {

    private final MinStack2 o = new MinStack2();

    @Test
    void test1() {
        o.push(-2);
        o.push(0);
        o.push(-1);
        assertEquals(-2, o.min());
        assertEquals(-1, o.top());
        o.pop();
        assertEquals(-2, o.min());
    }
}