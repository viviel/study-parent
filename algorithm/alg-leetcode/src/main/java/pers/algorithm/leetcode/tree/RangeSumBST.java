package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null == root) {
            return 0;
        }
        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (high < root.val) {
            return rangeSumBST(root.left, low, high);
        } else {
            return rangeSumBST(root.right, low, high);
        }
    }
}