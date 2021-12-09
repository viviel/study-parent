package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }
        if (root.left == null) {
            return hasPathSum(root.right, targetSum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, targetSum - root.val);
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum2(root.left, sum - root.val)
                || hasPathSum2(root.right, sum - root.val);
    }
}
