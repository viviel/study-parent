package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class SumOfLeftLeavesTest {

    private final SumOfLeftLeaves o = new SumOfLeftLeaves();

    @Test
    void test1() {
        assertEquals(24, o.sumOfLeftLeaves(TreeUtils.generateTree6()));
        assertEquals(-5, o.sumOfLeftLeaves(TreeUtils.generateTree7()));
        assertEquals(4, o.sumOfLeftLeaves(TreeUtils.generateTree14()));
    }

    @Test
    void test2() {
        assertEquals(24, o.sumOfLeftLeaves2(TreeUtils.generateTree6()));
        assertEquals(-5, o.sumOfLeftLeaves2(TreeUtils.generateTree7()));
        assertEquals(4, o.sumOfLeftLeaves2(TreeUtils.generateTree14()));
    }
}
