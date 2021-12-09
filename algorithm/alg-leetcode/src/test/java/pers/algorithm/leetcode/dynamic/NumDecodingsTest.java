package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumDecodingsTest {

    private NumDecodings o;

    @BeforeEach
    void setUp() {
        o = new NumDecodings2();
    }

    @Test
    void t11() {
        int ans = o.numDecodings("6");
        assertEquals(1, ans);
    }

    @Test
    void t12() {
        int ans = o.numDecodings("06");
        assertEquals(0, ans);
    }

    @Test
    void t13() {
        int ans = o.numDecodings("106");
        assertEquals(1, ans);
    }

    @Test
    void t14() {
        int ans = o.numDecodings("1106");
        assertEquals(1, ans);
    }

    @Test
    void t1() {
        int ans = o.numDecodings("11106");
        assertEquals(2, ans);
    }

    @Test
    void t2() {
        int ans = o.numDecodings("12");
        assertEquals(2, ans);
    }

    @Test
    void t21() {
        int ans = o.numDecodings("2");
        assertEquals(1, ans);
    }

    @Test
    void t3() {
        int ans = o.numDecodings("226");
        assertEquals(3, ans);
    }

    @Test
    void t4() {
        int ans = o.numDecodings("06");
        assertEquals(0, ans);
    }

    /**
     * 1234
     * <p>
     * 1 2 3 4
     * 12 3 4
     * 1 23 4
     */
    @Test
    void t5() {
    }

    @Test
    void t6() {
        int ans = o.numDecodings("111111111111111111111111111111111111111111111");
        assertEquals(1836311903, ans);
    }

    @Test
    void t7() {
        int ans = o.numDecodings("0");
        assertEquals(0, ans);
    }

    @Test
    void t8() {
        int ans = o.numDecodings("10");
        assertEquals(1, ans);
    }
}
