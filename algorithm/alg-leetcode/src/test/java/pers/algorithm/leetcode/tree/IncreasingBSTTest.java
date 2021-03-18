package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class IncreasingBSTTest {

    private final IncreasingBST o = new IncreasingBST();

    @Test
    void test1() {
        TreeNode r = o.increasingBST(TreeUtils.generateTree18());
        System.out.println(r);
    }
}