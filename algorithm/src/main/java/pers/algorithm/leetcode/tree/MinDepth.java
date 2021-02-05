package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = minDepth(root.left);
        int rd = minDepth(root.right);
        if (ld == 0) {
            return rd + 1;
        } else if (rd == 0) {
            return ld + 1;
        } else {
            return Math.min(ld, rd) + 1;
        }
    }
}
