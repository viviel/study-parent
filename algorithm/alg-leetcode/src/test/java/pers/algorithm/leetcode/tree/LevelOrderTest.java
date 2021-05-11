package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class LevelOrderTest {

    private final LevelOrder o = new LevelOrder();

    @Test
    void test1() {
        System.out.println(o.levelOrder(TreeUtils.generateTree6()));
    }
}
