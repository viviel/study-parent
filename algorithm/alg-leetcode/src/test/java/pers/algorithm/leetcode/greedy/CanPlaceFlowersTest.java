package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanPlaceFlowersTest {

    private final CanPlaceFlowers o = new CanPlaceFlowers();

    @Test
    void test() {
        assertTrue(o.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(o.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
