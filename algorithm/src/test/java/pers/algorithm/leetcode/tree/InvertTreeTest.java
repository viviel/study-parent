package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class InvertTreeTest {

    private final InvertTree o = new InvertTree();

    @Test
    void test1() {
        TreeNode treeNode = o.invertTree(TreeUtils.generateTree12());
        System.out.println(treeNode);
    }
}
