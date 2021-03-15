package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

class FindModeTest {

    private final FindMode o = new FindMode();

    @Test
    void test1() {
        o.findMode(TreeUtils.generateTree12());
    }
}
