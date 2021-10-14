package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchRangeTest {

    private SearchRange o;

    @BeforeEach
    void setUp() {
        o = new SearchRange();
    }

    @Test
    void test1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = o.searchRange(nums, target);
        assertArrayEquals(new int[]{3, 4}, ans);
    }

    @Test
    void test2() {
        int[] nums = {8, 8, 10};
        int target = 8;
        int[] ans = o.searchRange(nums, target);
        assertArrayEquals(new int[]{0, 1}, ans);
    }

    @Test
    void test3() {
        int[] nums = {7, 8, 8};
        int target = 8;
        int[] ans = o.searchRange(nums, target);
        assertArrayEquals(new int[]{1, 2}, ans);
    }

    @Test
    void test4() {
        int[] nums = {7, 8, 8};
        int target = 9;
        int[] ans = o.searchRange(nums, target);
        assertArrayEquals(new int[]{-1, -1}, ans);
    }
}
