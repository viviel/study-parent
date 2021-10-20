package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSum2Test {

    private CombinationSum2 o;

    @BeforeEach
    void setUp() {
        o = new CombinationSum22();
    }

    /**
     * 1 1 2 5 6 7 10
     */
    @Test
    void test1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = o.combinationSum2(candidates, target);
    }

    /**
     * 1 2 2 2 5
     */
    @Test
    void test2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> ans = o.combinationSum2(candidates, target);
    }

    @Test
    void test3() {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        List<List<Integer>> ans = o.combinationSum2(candidates, target);
    }
}
