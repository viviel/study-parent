package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinDeletionSizeTest {

    private final MinDeletionSize o = new MinDeletionSize();

    @Test
    void test1() {
        assertEquals(1, o.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        assertEquals(0, o.minDeletionSize(new String[]{"a", "b"}));
    }
}