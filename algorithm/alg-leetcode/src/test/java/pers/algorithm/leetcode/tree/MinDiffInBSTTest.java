package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinDiffInBSTTest {

    private final MinDiffInBST o = new MinDiffInBST();

    @Test
    void test1() {
        assertEquals(1, o.minDiffInBST(TreeUtils.generateTree12()));
    }
}