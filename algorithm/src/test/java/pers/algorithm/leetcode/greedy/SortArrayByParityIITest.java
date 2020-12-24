package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByParityIITest {

    private final SortArrayByParityII o = new SortArrayByParityII();

    @Test
    void test1() {
        assertArrayEquals(new int[]{4, 5, 2, 7}, o.sortArrayByParityII(new int[]{4, 2, 5, 7}));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{4, 5, 2, 7}, o.sortArrayByParityII2(new int[]{4, 2, 5, 7}));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{4, 5, 2, 7}, o.sortArrayByParityII3(new int[]{4, 2, 5, 7}));
    }
}