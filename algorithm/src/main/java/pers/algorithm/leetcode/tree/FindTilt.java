package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
class FindTilt {

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        traversal(root);
        return tilt;
    }

    public int traversal(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftVal = traversal(root.left);
        int rightVal = traversal(root.right);
        tilt += Math.abs(leftVal - rightVal);
        return leftVal + rightVal + root.val;
    }
}