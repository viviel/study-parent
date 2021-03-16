package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        return traversal(root, root.val);
    }

    private int traversal(TreeNode root, int min) {
        if (null == root) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        int l = traversal(root.left, min);
        int r = traversal(root.right, min);
        if (l > min && r > min) {
            return Math.min(l, r);
        }
        return Math.max(l, r);
    }
}