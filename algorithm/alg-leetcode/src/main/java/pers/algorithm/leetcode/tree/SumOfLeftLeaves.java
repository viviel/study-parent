package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean flag) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right && flag) {
            return root.val;
        } else {
            return sum(root.left, true) + sum(root.right, false);
        }
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int res = 0;
        if (null != root.left && null == root.left.left && null == root.left.right) {
            res += root.left.val;
        }
        return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right) + res;
    }
}
