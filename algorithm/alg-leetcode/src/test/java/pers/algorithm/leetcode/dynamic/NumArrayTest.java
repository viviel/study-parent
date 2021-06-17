package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumArrayTest {

    @Test
    void test1() {
        NumArray o = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, o.sumRange(0, 2));
        assertEquals(-1, o.sumRange(2, 5));
    }
}
