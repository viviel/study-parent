package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;

class SortedArrayToBSTTest {

    private final SortedArrayToBST o = new SortedArrayToBST();

    @Test
    void test1() {
        TreeNode result = o.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(result);
    }
}
