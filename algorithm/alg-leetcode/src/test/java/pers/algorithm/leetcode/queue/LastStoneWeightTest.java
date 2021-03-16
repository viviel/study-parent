package pers.algorithm.leetcode.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightTest {

    private final LastStoneWeight o = new LastStoneWeight();

    @Test
    void test1() {
        assertEquals(1, o.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
