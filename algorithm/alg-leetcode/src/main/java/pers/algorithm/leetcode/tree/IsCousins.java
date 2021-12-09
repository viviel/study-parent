package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        return depth(root, x, 0) == depth(root, y, 0) && !brother(root, x, y);
    }

    private int depth(TreeNode t, int v, int d) {
        if (null == t) {
            return -1;
        }
        if (t.val == v) {
            return d;
        } else {
            int l = depth(t.left, v, d + 1);
            if (l > -1) {
                return l;
            }
            int r = depth(t.right, v, d + 1);
            return Math.max(r, -1);
        }
    }

    private boolean brother(TreeNode t, int x, int y) {
        if (null == t) {
            return false;
        }
        if (null != t.left && (t.left.val == x || t.left.val == y) && null != t.right && (t.right.val == x || t.right.val == y)) {
            return true;
        } else {
            return brother(t.left, x, y) || brother(t.right, x, y);
        }
    }

    int xp, xd, yp, yd;

    private void traversal(TreeNode t, int x, int y, int d, int p) {
        if (null == t) {
            return;
        }
        if (t.val == x) {
            xp = p;
            xd = d;
        } else if (t.val == y) {
            yp = p;
            yd = d;
        } else {
            traversal(t.left, x, y, d + 1, t.val);
            traversal(t.right, x, y, d + 1, t.val);
        }
    }
}