package pers.algorithm.leetcode.tree.search;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class ConvertBiNodeTest {

    private final ConvertBiNode o = new ConvertBiNode();

    @Test
    void test1() {
        TreeNode r = o.convertBiNode(TreeUtils.generateTree12());
    }
}
