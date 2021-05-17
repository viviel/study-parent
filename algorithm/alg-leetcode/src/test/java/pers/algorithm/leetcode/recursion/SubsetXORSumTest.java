package pers.algorithm.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubsetXORSumTest {

    private final SubsetXORSum o = new SubsetXORSum();

    @Test
    void test1() {
        assertEquals(28, o.subsetXORSum(new int[]{2, 5, 6}));
    }

    @Test
    void test2() {
        assertEquals(6, o.subsetXORSum(new int[]{1, 3}));
    }
}
