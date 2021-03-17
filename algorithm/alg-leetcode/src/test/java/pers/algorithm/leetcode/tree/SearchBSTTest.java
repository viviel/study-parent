package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class SearchBSTTest {

    private final SearchBST o = new SearchBST();

    @Test
    void test1() {
        TreeNode r = o.searchBST(TreeUtils.generateTree12(), 2);
        System.out.println(r);
    }

    @Test
    void test2() {
        TreeNode r = o.searchBST(TreeUtils.generateTree12(), 9);
        System.out.println(r);
    }
}