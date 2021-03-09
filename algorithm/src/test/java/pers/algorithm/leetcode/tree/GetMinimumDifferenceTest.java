package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class GetMinimumDifferenceTest {

    private final GetMinimumDifference o = new GetMinimumDifference();

    @Test
    void test1() {
        assertEquals(1, o.getMinimumDifference(TreeUtils.generateTree15()));
    }
}
