package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinFlipsTest {

    private MinFlips o;

    @BeforeEach
    void setUp() {
        o = new MinFlips2();
    }

    @Test
    void test1() {
        int ans = o.minFlips(2, 6, 5);
        assertEquals(3, ans);
    }

    /**
     * 100
     * 010
     * 111
     */
    @Test
    void test2() {
        int ans = o.minFlips(4, 2, 7);
        assertEquals(1, ans);
    }
}
