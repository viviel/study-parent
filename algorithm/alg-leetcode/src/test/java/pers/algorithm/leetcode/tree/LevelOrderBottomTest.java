package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class LevelOrderBottomTest {

    private final LevelOrderBottom o = new LevelOrderBottom();

    @Test
    void test1() {
        System.out.println(o.levelOrderBottom(TreeUtils.generateTree6()));
    }
}
