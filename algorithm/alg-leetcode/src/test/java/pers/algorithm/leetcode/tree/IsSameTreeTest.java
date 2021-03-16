package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pers.algorithm.leetcode.tree.common.TreeUtils.*;

class IsSameTreeTest {

    private final IsSameTree o = new IsSameTree();

    @Test
    void test() {
        TreeNode tree1 = generateTree1();
        TreeNode tree2 = generateTree1();
        assertTrue(o.isSameTree(tree1, tree2));
    }

    @Test
    void test2() {
        TreeNode tree1 = generateTree2();
        TreeNode tree2 = generateTree3();
        assertFalse(o.isSameTree(tree1, tree2));
    }
}