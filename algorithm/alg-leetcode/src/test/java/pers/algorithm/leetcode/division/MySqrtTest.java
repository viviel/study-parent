package pers.algorithm.leetcode.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySqrtTest {

    private final MySqrt o = new MySqrt();

    @Test
    void test1() {
        assertEquals(2, o.mySqrt(4));
        assertEquals(2, o.mySqrt(8));
        assertEquals(0, o.mySqrt(0));
        assertEquals(1, o.mySqrt(1));
        // 0 1 2
        assertEquals(1, o.mySqrt(2));
        assertEquals(3, o.mySqrt(9));
        assertEquals(46339, o.mySqrt(2147395599));
    }
}