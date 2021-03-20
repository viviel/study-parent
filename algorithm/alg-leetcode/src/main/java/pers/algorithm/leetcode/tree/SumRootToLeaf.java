package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        List<String> l = new ArrayList<>();
        traversal(root, l, new StringBuilder());
        return l.stream().mapToInt(e -> Integer.parseInt(e, 2)).sum();
    }

    private void traversal(TreeNode t, List<String> l, StringBuilder s) {
        if (null == t) {
            return;
        }
        s.append(t.val);
        if (null == t.left && null == t.right) {
            l.add(s.toString());
            return;
        }
        traversal(t.left, l, new StringBuilder(s));
        traversal(t.right, l, new StringBuilder(s));
    }

    public int sumRootToLeaf2(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        traversal2(root, l, 0);
        int r = 0;
        for (Integer e : l) {
            r += e;
        }
        return r;
    }

    private void traversal2(TreeNode t, List<Integer> l, Integer i) {
        if (null == t) {
            return;
        }
        i = (i << 1) + t.val;
        if (null == t.left && null == t.right) {
            l.add(i);
            return;
        }
        traversal2(t.left, l, i);
        traversal2(t.right, l, i);
    }

    public int sumRootToLeaf3(TreeNode root) {
        return traversal3(root, 0);
    }

    private int traversal3(TreeNode t, Integer i) {
        if (null == t) {
            return 0;
        }
        i = (i << 1) + t.val;
        if (null == t.left && null == t.right) {
            return i;
        }
        return traversal3(t.left, i) + traversal3(t.right, i);
    }
}