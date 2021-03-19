package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumBSTTest {

    private final RangeSumBST o = new RangeSumBST();

    @Test
    void test1() {
        assertEquals(4, o.rangeSumBST(TreeUtils.generateTree21(), 1, 3));
    }
}