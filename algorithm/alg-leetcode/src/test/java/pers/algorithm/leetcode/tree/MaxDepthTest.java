package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pers.algorithm.leetcode.tree.common.TreeUtils.generateTree6;

class MaxDepthTest {

    private final MaxDepth o = new MaxDepth();

    @Test
    void test1() {
        assertEquals(3, o.maxDepth(generateTree6()));
    }
}
