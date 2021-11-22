package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKthLargestTest {

    private FindKthLargest o;

    @BeforeEach
    void setUp() {
        o = new FindKthLargest2();
    }

    /**
     * [3,2,1,5,6,4], k = 2
     * 1,2,3,4,5,6
     * 4,2,1,5,6,3
     */
    @Test
    void t1() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = o.findKthLargest(nums, k);
        assertEquals(5, ans);
    }

    @Test
    void t2() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int ans = o.findKthLargest(nums, k);
        assertEquals(4, ans);
    }

    @Test
    void t3() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int ans = o.findKthLargest(nums, 4);
    }

    @Test
    void t4() {
        int[] nums = new int[]{1};
        int ans = o.findKthLargest(nums, 1);
        assertEquals(1, ans);
    }

    @Test
    void t5() {
        int[] nums = new int[]{2, 1};
        int ans = o.findKthLargest(nums, 2);
        assertEquals(1, ans);
    }

    @Test
    void t6() {
        int[] nums = new int[]{99, 99};
        int ans = o.findKthLargest(nums, 1);
        assertEquals(99, ans);
    }
}
