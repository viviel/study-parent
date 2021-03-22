package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * |        1
 * |       / \
 * |      2   2
 * |     / \
 * |    3   3
 * |   / \
 * |  4   4
 * 返回false 。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 树的结点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        int hight = treeHight(root);
        if (Integer.MAX_VALUE == hight) {
            return false;
        }
        return true;
    }

    private int treeHight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHight = treeHight(node.left);
        int rHight = treeHight(node.right);
        if (Integer.MAX_VALUE == lHight || Integer.MAX_VALUE == rHight || Math.abs(lHight - rHight) > 1) {
            return Integer.MAX_VALUE;
        }
        return Math.max(lHight, rHight) + 1;
    }

    private boolean sign = true;

    public boolean isBalanced2(TreeNode root) {
        traversal(root);
        return sign;
    }

    private int traversal(TreeNode t) {
        if (null == t) {
            return 0;
        }
        int l = traversal(t.left);
        int r = traversal(t.right);
        if (Math.abs(l - r) > 1) {
            sign = false;
        }
        return Math.max(l, r) + 1;
    }
}
