package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsCousinsTest {

    private final IsCousins o = new IsCousins();

    @Test
    void test1() {
        assertFalse(o.isCousins(TreeUtils.generateTree24(), 6, 7));
        assertTrue(o.isCousins(TreeUtils.generateTree25(), 5, 4));
    }
}