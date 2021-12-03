package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class LowestCommonAncestor3Test {

    private LowestCommonAncestor3 o;

    @BeforeEach
    void setUp() {
        o = new LowestCommonAncestor3();
    }

    @Test
    void t1() {
        TreeNode node = TreeUtils.generateTree23();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode ans = o.lowestCommonAncestor(node, p, q);
    }
}
