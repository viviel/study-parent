package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiameterOfBinaryTreeTest {

    private final DiameterOfBinaryTree o = new DiameterOfBinaryTree();

    @Test
    void test1() {
        assertEquals(0, o.diameterOfBinaryTree(TreeUtils.generateTree14()));
        assertEquals(3, o.diameterOfBinaryTree2(TreeUtils.generateTree14()));
    }
}
