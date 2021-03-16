package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class MergeTreesTest {

    private final MergeTrees o = new MergeTrees();

    @Test
    void test1() {
        TreeNode r = o.mergeTrees(TreeUtils.generateTree19(), TreeUtils.generateTree20());
        System.out.println(r);
    }

    @Test
    void test2() {
        TreeNode r = o.mergeTrees(TreeUtils.generateTree19(), TreeUtils.generateTree20());
        System.out.println(r);
    }
}