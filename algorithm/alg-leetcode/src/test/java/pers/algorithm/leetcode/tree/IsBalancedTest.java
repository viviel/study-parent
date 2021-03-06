package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsBalancedTest {

    private final IsBalanced o = new IsBalanced();

    @Test
    void test1() {
        assertFalse(o.isBalanced(TreeUtils.generateTree9()));
        assertTrue(o.isBalanced(TreeUtils.generateTree7()));
    }

    @Test
    void test2() {
        assertFalse(o.isBalanced2(TreeUtils.generateTree9()));
    }

    @Test
    void test3() {
        assertTrue(o.isBalanced2(TreeUtils.generateTree7()));
    }
}
