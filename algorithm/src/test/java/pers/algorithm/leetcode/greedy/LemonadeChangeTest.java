package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LemonadeChangeTest {

    private final LemonadeChange o = new LemonadeChange();

    @Test
    void test1() {
        assertTrue(o.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        assertTrue(o.lemonadeChange(new int[]{5, 5, 10}));
        assertFalse(o.lemonadeChange(new int[]{10, 10}));
    }
}