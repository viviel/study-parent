package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSymmetricTest {

    private final IsSymmetric o = new IsSymmetric();

    private TreeNode generateTree1() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.left.left = new TreeNode(3);
        result.left.right = new TreeNode(4);
        result.right = new TreeNode(2);
        result.right.left = new TreeNode(4);
        result.right.right = new TreeNode(3);
        return result;
    }

    private TreeNode generateTree2() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.left.right = new TreeNode(3);
        result.right = new TreeNode(2);
        result.right.right = new TreeNode(3);
        return result;
    }

    @Test
    void test1() {
        assertTrue(o.isSymmetric(generateTree1()));
        assertFalse(o.isSymmetric(generateTree2()));
    }
}