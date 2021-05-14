package pers.algorithm.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TribonacciTest {

    private final Tribonacci o = new Tribonacci();

    @Test
    void test1() {
        assertEquals(0, o.tribonacci(0));
        assertEquals(1, o.tribonacci(1));
        assertEquals(1, o.tribonacci(2));
        assertEquals(2, o.tribonacci(3));
        assertEquals(4, o.tribonacci(4));
        assertEquals(1389537, o.tribonacci(25));
    }

    @Test
    void test2() {
        assertEquals(0, o.tribonacci2(0));
        assertEquals(1, o.tribonacci2(1));
        assertEquals(1, o.tribonacci2(2));
        assertEquals(2, o.tribonacci2(3));
        assertEquals(4, o.tribonacci2(4));
        assertEquals(1389537, o.tribonacci2(25));
    }
}
