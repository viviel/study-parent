package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class LowestCommonAncestorTest {

    private final LowestCommonAncestor o = new LowestCommonAncestor();

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

    @Test
    void test3() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode treeNode = o.lowestCommonAncestor2(TreeUtils.generateTree12(), p, q);
        System.out.println(treeNode);
    }

    @Test
    void test4() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode treeNode = o.lowestCommonAncestor3(TreeUtils.generateTree12(), p, q);
        System.out.println(treeNode);
    }
}
