package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSecondMinimumValueTest {

    private final FindSecondMinimumValue o = new FindSecondMinimumValue();

    @Test
    void test1() {
        assertEquals(5, o.findSecondMinimumValue(TreeUtils.generateTree21()));
    }

    @Test
    void test2() {
        assertEquals(-1, o.findSecondMinimumValue(TreeUtils.generateTree22()));
    }
}