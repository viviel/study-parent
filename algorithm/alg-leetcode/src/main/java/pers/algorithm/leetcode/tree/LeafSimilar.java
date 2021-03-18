package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        traversal(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        traversal(root2, l2);
        return l1.equals(l2);
    }

    public void traversal(TreeNode t, List<Integer> l) {
        if (null == t) {
            return;
        }
        traversal(t.left, l);
        if (null == t.left && null == t.right) {
            l.add(t.val);
        }
        traversal(t.right, l);
    }
}