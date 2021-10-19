package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumTest {

    private CombinationSum o;

    @BeforeEach
    void setUp() {
        o = new CombinationSum();
    }

    @Test
    void test1() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = o.combinationSum(candidates, target);
    }

    @Test
    void test2() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> ans = o.combinationSum(candidates, target);
    }

    @Test
    void test3() {
        int[] candidates = new int[]{2};
        int target = 1;
        List<List<Integer>> ans = o.combinationSum(candidates, target);
    }

    @Test
    void test4() {
        int[] candidates = new int[]{1};
        int target = 1;
        List<List<Integer>> ans = o.combinationSum(candidates, target);
    }
}
