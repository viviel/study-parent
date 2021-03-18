package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LeafSimilarTest {

    private final LeafSimilar o = new LeafSimilar();

    @Test
    void test1() {
        assertTrue(o.leafSimilar(TreeUtils.generateTree23(), TreeUtils.generateTree24()));
    }
}