package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindTargetTest {

    private final FindTarget o = new FindTarget();

    @Test
    void test1() {
        assertTrue(o.findTarget(TreeUtils.generateTree12(), 16));
        assertFalse(o.findTarget(TreeUtils.generateTree12(), 17));
    }

    @Test
    void test2() {
        assertTrue(o.findTarget2(TreeUtils.generateTree12(), 16));
        assertFalse(o.findTarget2(TreeUtils.generateTree12(), 17));
    }
}