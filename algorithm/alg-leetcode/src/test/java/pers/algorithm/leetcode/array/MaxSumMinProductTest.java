package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumMinProductTest {

    private MaxSumMinProduct o;

    @BeforeEach
    void setUp() {
        o = new MaxSumMinProduct();
    }

    /**
     * 1, 2, 2, 3
     * 2, 3, 2
     */
    @Test
    void test1() {
        int[] a = new int[]{1, 2, 3, 2};
        int r = o.maxSumMinProduct(a);
        assertEquals(14, r);
    }

    /**
     * 1,2,2,3,3
     * <p>
     * 3 * (3 + 3)
     * 2 * (2 + 3 + 3)
     */
    @Test
    void test2() {
        int[] a = new int[]{2, 3, 3, 1, 2};
        int r = o.maxSumMinProduct(a);
        assertEquals(18, r);
    }

    /**
     * 1,2,3,4,5,6
     * <p>
     * 6 * 6                         36
     * 5 * (5 + 6)                   55
     * 4 * (4 + 5 + 6)               60
     * 3 * (3 + 4 + 5 + 6)           54
     */
    @Test
    void test3() {
        int[] a = new int[]{3, 1, 5, 6, 4, 2};
        int r = o.maxSumMinProduct(a);
        assertEquals(60, r);
    }

    /**
     * 1,2,3,4,5,6
     * <p>
     * 6 * 6                         36
     * 5 * (5 + 6)                   55
     * 4 * (4 + 5 + 6)               60
     * 3 * (3 + 4 + 5 + 6)           54
     */
    @Test
    void test4() {
        int[] a = new int[]{3, 1, 5, 6, 4, 2};
        int r = o.maxSumMinProduct2(a);
        assertEquals(60, r);
    }

    /**
     * 1,1,1,1,2,2,2,3,5,5
     * <p>
     * 5 * 5                         25
     * 5 * (5 + 5)                   50
     * 3 * (3 + 5 + 5)               39
     * 2 * (2 + 3 + 5 + 5)           30
     */
    @Test
    void test5() {
        int[] a = new int[]{1, 1, 3, 2, 2, 2, 1, 5, 1, 5};
        int r = o.maxSumMinProduct(a);
        assertEquals(25, r);
    }
}
