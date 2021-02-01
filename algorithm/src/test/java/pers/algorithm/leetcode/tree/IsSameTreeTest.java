package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSameTreeTest {

    private final IsSameTree o = new IsSameTree();

    private IsSameTree.TreeNode generateTree1() {
        IsSameTree.TreeNode result = new IsSameTree.TreeNode(1);
        result.left = new IsSameTree.TreeNode(2);
        result.right = new IsSameTree.TreeNode(3);
        return result;
    }

    private IsSameTree.TreeNode generateTree2() {
        IsSameTree.TreeNode result = new IsSameTree.TreeNode(1);
        result.left = new IsSameTree.TreeNode(2);
        return result;
    }

    private IsSameTree.TreeNode generateTree3() {
        IsSameTree.TreeNode result = new IsSameTree.TreeNode(1);
        result.right = new IsSameTree.TreeNode(3);
        return result;
    }

    @Test
    void test() {
        IsSameTree.TreeNode tree1 = generateTree1();
        IsSameTree.TreeNode tree2 = generateTree1();
        assertTrue(o.isSameTree(tree1, tree2));
    }

    @Test
    void test2() {
        IsSameTree.TreeNode tree1 = generateTree2();
        IsSameTree.TreeNode tree2 = generateTree3();
        assertFalse(o.isSameTree(tree1, tree2));
    }
}