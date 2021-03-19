package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class IsUnivalTreeTest {

    private final IsUnivalTree o = new IsUnivalTree();

    @Test
    void test1() {
        assertTrue(o.isUnivalTree(TreeUtils.generateTree22()));
        assertFalse(o.isUnivalTree(TreeUtils.generateTree24()));
    }
}