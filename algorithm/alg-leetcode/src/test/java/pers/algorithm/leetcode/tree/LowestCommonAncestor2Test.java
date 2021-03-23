package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class LowestCommonAncestor2Test {

    private final LowestCommonAncestor2 o = new LowestCommonAncestor2();

    @Test
    void test1() {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(7);
        TreeNode treeNode = o.lowestCommonAncestor(TreeUtils.generateTree12(), p, q);
        System.out.println(treeNode);
    }

    @Test
    void test2() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode treeNode = o.lowestCommonAncestor(TreeUtils.generateTree12(), p, q);
        System.out.println(treeNode);
    }
}