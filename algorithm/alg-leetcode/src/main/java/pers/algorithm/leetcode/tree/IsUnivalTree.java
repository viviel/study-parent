package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        return traversal(root, root.val);
    }

    private boolean traversal(TreeNode t, int val) {
        if (null == t) {
            return true;
        }
        if (t.val != val) {
            return false;
        }
        return traversal(t.left, val) && traversal(t.right, val);
    }
}