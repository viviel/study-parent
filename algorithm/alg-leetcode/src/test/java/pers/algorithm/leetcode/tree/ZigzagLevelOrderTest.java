package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeNode;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import java.util.List;

class ZigzagLevelOrderTest {

    private ZigzagLevelOrder o;

    @BeforeEach
    void setUp() {
        o = new ZigzagLevelOrder();
    }

    /**
     * 4 2 7 1 3 6 9
     * 4
     * <p>
     * 2 7
     * 7 1 3
     * 1 3 6 9
     */
    @Test
    void t1() {
        TreeNode treeNode = TreeUtils.generateTree12();
        List<List<Integer>> ans = o.zigzagLevelOrder(treeNode);
    }

    /**
     * [0,2,4,1,null,3,-1,5,1,null,6,null,8]
     */
    @Test
    void t2() {
        TreeNode treeNode = TreeUtils.generateTree27();
        List<List<Integer>> ans = o.zigzagLevelOrder(treeNode);
    }
}
