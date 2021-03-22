package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestTest {

    private final KthLargest o = new KthLargest();

    @Test
    void test1() {
        assertEquals(4, o.kthLargest(TreeUtils.generateTree12(), 4));
    }

    @Test
    void test2() {
        assertEquals(4, o.kthLargest2(TreeUtils.generateTree12(), 4));
    }
}
