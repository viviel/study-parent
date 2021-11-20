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

    /**
     * |       4
     * |     /   \
     * |    2     7
     * |   / \   / \
     * |  1   3 6   9
     * <p>
     * 先序：4 2 1 3 7 6 9
     * 中序：1 2 3 4 6 7 9
     * 后序：1 3 2 6 9 7 4
     */
    public static TreeNode generateTree12() {
        TreeNode result = new TreeNode(4);
        result.left = new TreeNode(2);
        result.right = new TreeNode(7);
        result.left.left = new TreeNode(1);
        result.left.right = new TreeNode(3);
        result.right.left = new TreeNode(6);
        result.right.right = new TreeNode(9);
        return result;
    }

    /**
     * |     1
     * |   /   \
     * |  2     3
     * |   \
     * |    5
     */
    public static TreeNode generateTree13() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(3);
        result.left.right = new TreeNode(5);
        return result;
    }

    /**
     * |      1
     * |     / \
     * |    2   3
     * |   / \
     * |  4   5
     */
    public static TreeNode generateTree14() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(3);
        result.left.left = new TreeNode(4);
        result.left.right = new TreeNode(5);
        return result;
    }

    /**
     * |  1
     * |   \
     * |    3
     * |   /
     * |  2
     */
    public static TreeNode generateTree15() {
        TreeNode result = new TreeNode(1);
        result.right = new TreeNode(3);
        result.right.left = new TreeNode(2);
        return result;
    }

    /**
     * |        4
     * |      /   \
     * |     2     9
     * |   /  \     \
     * |  3    5     7
     */
    public static TreeNode generateTree16() {
        TreeNode result = new TreeNode(4);
        result.left = new TreeNode(2);
        result.right = new TreeNode(9);
        result.left.left = new TreeNode(3);
        result.left.right = new TreeNode(5);
        result.right.right = new TreeNode(7);
        return result;
    }

    /**
     * |      3
     * |     / \
     * |    4   5
     * |   / \
     * |  1   2
     */
    public static TreeNode generateTree17() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(4);
        result.right = new TreeNode(5);
        result.left.left = new TreeNode(1);
        result.left.right = new TreeNode(2);
        return result;
    }

    /**
     * |    4
     * |   / \
     * |  1   2
     */
    public static TreeNode generateTree18() {
        TreeNode result = new TreeNode(4);
        result.left = new TreeNode(1);
        result.right = new TreeNode(2);
        return result;
    }

    /**
     * [1,2,null,3]
     * |      1
     * |     /
     * |    2
     * |   /
     * |  3
     */
    public static TreeNode generateTree19() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.left.left = new TreeNode(3);
        return result;
    }

    /**
     * [1,null,2,null,3]
     * |  1
     * |   \
     * |    2
     * |     \
     * |      3
     */
    public static TreeNode generateTree20() {
        TreeNode result = new TreeNode(1);
        result.right = new TreeNode(2);
        result.right.right = new TreeNode(3);
        return result;
    }

    /**
     * [2,2,5,null,null,5,7]
     * |    2
     * |   / \
     * |  2   5
     * |     / \
     * |    5   7
     */
    public static TreeNode generateTree21() {
        TreeNode result = new TreeNode(2);
        result.left = new TreeNode(2);
        result.right = new TreeNode(5);
        result.right.left = new TreeNode(5);
        result.right.right = new TreeNode(7);
        return result;
    }

    /**
     * [2,2,2]
     * |    2
     * |   / \
     * |  2   2
     */
    public static TreeNode generateTree22() {
        TreeNode result = new TreeNode(2);
        result.left = new TreeNode(2);
        result.right = new TreeNode(2);
        return result;
    }

    /**
     * [2,2,2]
     * |           3
     * |        /     \
     * |       5       1
     * |      / \     / \
     * |     6   2   9   8
     * |        / \
     * |       7   4
     */
    public static TreeNode generateTree23() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(5);
        result.right = new TreeNode(1);
        result.left.left = new TreeNode(6);
        result.left.right = new TreeNode(2);
        result.right.left = new TreeNode(9);
        result.right.right = new TreeNode(8);
        result.left.right.left = new TreeNode(7);
        result.left.right.right = new TreeNode(4);
        return result;
    }

    /**
     * [2,2,2]
     * |           3
     * |        /     \
     * |       5       1
     * |      / \     / \
     * |     6   7   4   2
     * |                / \
     * |               9   8
     */
    public static TreeNode generateTree24() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(5);
        result.right = new TreeNode(1);
        result.left.left = new TreeNode(6);
        result.left.right = new TreeNode(7);
        result.right.left = new TreeNode(4);
        result.right.right = new TreeNode(2);
        result.right.right.left = new TreeNode(9);
        result.right.right.right = new TreeNode(8);
        return result;
    }

    /**
     * [2,2,5,null,null,5,7]
     * |    1
     * |   / \
     * |  2   3
     * |   \   \
     * |   4    5
     */
    public static TreeNode generateTree25() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(2);
        result.right = new TreeNode(3);
        result.left.right = new TreeNode(4);
        result.right.right = new TreeNode(5);
        return result;
    }

    /**
     * |       1
     * |     /   \
     * |    0     1
     * |   / \   / \
     * |  0   1 0   1
     */
    public static TreeNode generateTree26() {
        TreeNode result = new TreeNode(1);
        result.left = new TreeNode(0);
        result.right = new TreeNode(1);
        result.left.left = new TreeNode(0);
        result.left.right = new TreeNode(1);
        result.right.left = new TreeNode(0);
        result.right.right = new TreeNode(1);
        return result;
    }

    /**
     * [0,2,4,1,null,3,-1,5,1,null,6,null,8]
     * |             0
     * |         /       \
     * |       2          4
     * |     /          /   \
     * |   1          3      -1
     * |  / \          \       \
     * | 5   1          6       8
     */
    public static TreeNode generateTree27() {
        TreeNode r = new TreeNode(0);
        r.left = new TreeNode(2);
        r.right = new TreeNode(4);
        r.left.left = new TreeNode(1);
        r.right.left = new TreeNode(3);
        r.right.right = new TreeNode(-1);
        r.left.left.left = new TreeNode(5);
        r.left.left.right = new TreeNode(1);
        r.right.left.right = new TreeNode(6);
        r.right.right.right = new TreeNode(8);
        return r;
    }
}
