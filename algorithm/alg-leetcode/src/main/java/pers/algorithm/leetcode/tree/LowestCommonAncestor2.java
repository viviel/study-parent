package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    private TreeNode traversal(TreeNode t, TreeNode p, TreeNode q) {
        if (null == t) {
            return null;
        }
        if (t.val == p.val || t.val == q.val) {
            return t;
        }
        if (find(t.left, p) && find(t.left, q)) {
            return traversal(t.left, p, q);
        } else if (find(t.right, p) && find(t.right, q)) {
            return traversal(t.right, p, q);
        } else {
            return t;
        }
    }

    private boolean find(TreeNode t, TreeNode p) {
        if (null == t) {
            return false;
        }
        if (t.val == p.val) {
            return true;
        }
        return find(t.left, p) || find(t.right, p);
    }
}