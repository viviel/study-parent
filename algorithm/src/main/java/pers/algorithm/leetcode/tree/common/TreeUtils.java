package pers.algorithm.leetcode.tree.common;

public class TreeUtils {

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

    /**
     * |       0
     * |      / \
     * |    -3   9
     * |    /   /
     * |  -10  5
     */
    public static TreeNode generateTree7() {
        TreeNode result = new TreeNode(0);
        result.left = new TreeNode(-3);
        result.right = new TreeNode(9);
        result.left.left = new TreeNode(-10);
        result.right.left = new TreeNode(5);
        return result;
    }

    /**
     * |       0
     * |      / \
     * |    -3   9
     * |    /
     * |  -10
     * |     \
     * |     -9
     */
    public static TreeNode generateTree8() {
        TreeNode result = new TreeNode(0);
        result.left = new TreeNode(-3);
        result.right = new TreeNode(9);
        result.left.left = new TreeNode(-10);
        result.left.left.right = new TreeNode(-9);
        return result;
    }

    /**
     * [1,2,2,3,null,null,3,4,null,null,4]
     * |        1
     * |       / \
     * |      2   2
     * |     /     \
     * |    3       3
     * |   /         \
     * |  4           4
     */
    public static TreeNode generateTree9() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(2);
        result.left.left = new TreeNode(3);
        result.right.right = new TreeNode(3);
        result.left.left.left = new TreeNode(4);
        result.right.right.right = new TreeNode(4);
        return result;
    }

    /**
     * [2,null,3,null,4,null,5,null,6]
     * |        2
     * |         \
     * |          3
     * |           \
     * |            5
     * |             \
     * |              6
     */
    public static TreeNode generateTree10() {
        TreeNode result = new TreeNode(2);
        result.right = new TreeNode(2);
        result.right.right = new TreeNode(4);
        result.right.right.right = new TreeNode(5);
        result.right.right.right.right = new TreeNode(6);
        return result;
    }

    /**
     * |    1
     * |   /
     * |  2
     */
    public static TreeNode generateTree11() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        return result;
    }
}
