package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;

class SortedArrayToBST2Test {

    private final SortedArrayToBST2 o = new SortedArrayToBST2();

    @Test
    void test1() {
        TreeNode r = o.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(r);
    }
}