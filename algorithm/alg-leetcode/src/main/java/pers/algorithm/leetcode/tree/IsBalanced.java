package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
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
}
