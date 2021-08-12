package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsNearbyAlmostDuplicateTest {

    private ContainsNearbyAlmostDuplicate o;

    @BeforeEach
    void setUp() {
        o = new ContainsNearbyAlmostDuplicate();
    }

    @Test
    void test1() {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;
        int t = 0;
        boolean ans = o.containsNearbyAlmostDuplicate(nums, k, t);
        assertTrue(ans);
    }

    @Test
    void test2() {
        int[] nums = new int[]{1, 0, 1, 1};
        int k = 1;
        int t = 2;
        boolean ans = o.containsNearbyAlmostDuplicate(nums, k, t);
        assertTrue(ans);
    }

    @Test
    void test3() {
        int[] nums = new int[]{1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        boolean ans = o.containsNearbyAlmostDuplicate(nums, k, t);
        assertFalse(ans);
    }
}
