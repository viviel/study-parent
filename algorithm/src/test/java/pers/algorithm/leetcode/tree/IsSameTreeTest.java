package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSameTreeTest {

    private final IsSameTree o = new IsSameTree();

    private TreeNode generateTree1() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(3);
        return result;
    }

    private TreeNode generateTree2() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        return result;
    }

    private TreeNode generateTree3() {
        TreeNode result = new TreeNode(1);
        result.right = new TreeNode(3);
        return result;
    }

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