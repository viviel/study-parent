package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinDepthTest {

    private final MinDepth o = new MinDepth();

    @Test
    void test() {
        assertEquals(2, o.minDepth(TreeUtils.generateTree8()));
        assertEquals(5, o.minDepth(TreeUtils.generateTree10()));
    }
}
