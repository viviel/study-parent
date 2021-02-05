package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class HasPathSumTest {

    private final HasPathSum o = new HasPathSum();

    @Test
    void test() {
        assertTrue(o.hasPathSum(TreeUtils.generateTree6(), 30));
        assertFalse(o.hasPathSum(TreeUtils.generateTree11(), 1));
    }
}
