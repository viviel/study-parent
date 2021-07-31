package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NthUglyNumberTest {

    private NthUglyNumber o;

    @BeforeEach
    void setUp() {
        o = new NthUglyNumber();
    }

    /**
     * 1 2 3 4 5 6 7 8  9 10
     * 1 2 3 4 5 6 8 9 10 12
     */
    @Test
    void test1() {
        int r = o.nthUglyNumber(10);
        assertEquals(12, r);
    }
}
