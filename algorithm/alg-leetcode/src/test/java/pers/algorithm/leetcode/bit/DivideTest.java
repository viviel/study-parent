package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTest {

    private Divide o;

    @BeforeEach
    void setUp() {
        o = new Divide();
    }

    @Test
    void test1() {
        int ans = o.divide(10, 3);
        assertEquals(3, ans);
    }

    @Test
    void test2() {
        int ans = o.divide(10, -3);
        assertEquals(-3, ans);
    }

    @Test
    void test3() {
        int ans = o.divide(-10, -3);
        assertEquals(3, ans);
    }

    @Test
    void test4() {
        int ans = o.divide(0, -3);
        assertEquals(0, ans);
    }

    @Test
    void test5() {
        int ans = o.divide(-2147483648, -1);
        assertEquals(2147483647, ans);
    }

    @Test
    void test6() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
