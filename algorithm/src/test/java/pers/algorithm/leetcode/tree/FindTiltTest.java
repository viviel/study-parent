package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTiltTest {

    private final FindTilt o = new FindTilt();

    @Test
    void test1() {
        assertEquals(7, o.findTilt(TreeUtils.generateTree15()));
    }
}