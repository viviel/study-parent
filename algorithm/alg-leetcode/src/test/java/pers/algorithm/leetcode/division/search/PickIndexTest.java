package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.Test;

class PickIndexTest {

    @Test
    void test1() {
        int[] w = new int[]{1};
        PickIndex o = new PickIndex(w);
    }

    /**
     * 1,1
     * 1,2
     */
    @Test
    void test2() {
        int[] w = new int[]{1, 1};
        PickIndex o = new PickIndex(w);
    }

    /**
     * 1,4,5
     * 0,1,5,10
     */
    @Test
    void test3() {
        int[] w = new int[]{1, 3};
        PickIndex o = new PickIndex(w);
    }
}
