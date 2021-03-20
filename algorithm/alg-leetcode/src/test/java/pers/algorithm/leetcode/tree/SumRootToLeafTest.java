package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class SumRootToLeafTest {

    private final SumRootToLeaf o = new SumRootToLeaf();

    @Test
    void test1() {
        assertEquals(22, o.sumRootToLeaf(TreeUtils.generateTree26()));
    }

    @Test
    void test2() {
        assertEquals(22, o.sumRootToLeaf2(TreeUtils.generateTree26()));
    }

    @Test
    void test3() {
        assertEquals(22, o.sumRootToLeaf3(TreeUtils.generateTree26()));
    }
}