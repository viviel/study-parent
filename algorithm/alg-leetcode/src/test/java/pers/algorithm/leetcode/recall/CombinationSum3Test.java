package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 演绎
 * 归纳
 * 类比
 */
class CombinationSum3Test {

    private CombinationSum3 o;

    @BeforeEach
    void setUp() {
        o = new CombinationSum3();
    }

    /**
     * 1,2,4
     */
    @Test
    void test1() {
        List<List<Integer>> ans = o.combinationSum3(3, 7);
        System.out.println(ans);
    }

    /**
     * [1,2,6]
     * [1,3,5]
     * [2,3,4]
     */
    @Test
    void test2() {
        List<List<Integer>> ans = o.combinationSum3(3, 9);
        System.out.println(ans);
    }

    @Test
    void test3() {
        List<List<Integer>> ans = o.combinationSum3(9, 45);
        System.out.println(ans);
    }
}
