package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        } else {
            if ((hasNode(root.left, p) || hasNode(root.left, q))
                    && (hasNode(root.right, p) || hasNode(root.right, q))) {
                return root;
            } else if (hasNode(root.left, p)) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    private boolean hasNode(TreeNode root, TreeNode p) {
        if (null == root) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return hasNode(root.left, p) || hasNode(root.right, p);
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        } else if (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val)) {
            return root;
        } else if (root.val > Math.min(p.val, q.val)) {
            return lowestCommonAncestor2(root.left, p, q);
        } else {
            return lowestCommonAncestor2(root.right, p, q);
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor3(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor3(root.right, p, q);
        } else {
            return root;
        }
    }
}
