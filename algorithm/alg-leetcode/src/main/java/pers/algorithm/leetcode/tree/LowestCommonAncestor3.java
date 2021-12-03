package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LowestCommonAncestor3 {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return ans;
    }

    private boolean traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean t1 = traversal(root.left, p, q);
        boolean t2 = traversal(root.right, p, q);
        if ((root.val == p.val || root.val == q.val) && (t1 || t2)) {
            ans = root;
        } else if (t1 && t2) {
            ans = root;
        }
        return t1 || t2 || root.val == p.val || root.val == q.val;
    }
}
