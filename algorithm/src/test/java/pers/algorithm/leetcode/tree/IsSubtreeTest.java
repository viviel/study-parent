package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class IsSubtreeTest {

    private final IsSubtree o = new IsSubtree();

    @Test
    void test1() {
        assertTrue(o.isSubtree(TreeUtils.generateTree17(), TreeUtils.generateTree18()));
        assertFalse(o.isSubtree(TreeUtils.generateTree17(), TreeUtils.generateTree16()));
    }
}