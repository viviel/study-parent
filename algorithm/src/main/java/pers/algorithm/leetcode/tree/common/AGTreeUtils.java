package pers.algorithm.leetcode.tree.common;

public class AGTreeUtils {

    /**
     * |    1
     * |   / \
     * |  2   3
     */
    public static TreeNode generateTree1() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(3);
        return result;
    }

    /**
     * |    1
     * |   /
     * |  2
     */
    public static TreeNode generateTree2() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        return result;
    }

    /**
     * |  1
     * |   \
     * |    3
     */
    public static TreeNode generateTree3() {
        TreeNode result = new TreeNode(1);
        result.right = new TreeNode(3);
        return result;
    }

    /**
     * |      1
     * |     / \
     * |    2   2
     * |   / \ / \
     * |  3  4 4  3
     */
    public static TreeNode generateTree4() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.left.left = new TreeNode(3);
        result.left.right = new TreeNode(4);
        result.right = new TreeNode(2);
        result.right.left = new TreeNode(4);
        result.right.right = new TreeNode(3);
        return result;
    }

    /**
     * |    1
     * |   / \
     * |  2   2
     * |   \   \
     * |   3    3
     */
    public static TreeNode generateTree5() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.left.right = new TreeNode(3);
        result.right = new TreeNode(2);
        result.right.right = new TreeNode(3);
        return result;
    }

    /**
     * |    3
     * |   / \
     * |  9  20
     * |    /  \
     * |   15   7
     */
    public static TreeNode generateTree6() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(9);
        result.right = new TreeNode(20);
        result.right.left = new TreeNode(15);
        result.right.right = new TreeNode(7);
        return result;
    }
}
