package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tree2strTest {

    private final Tree2str o = new Tree2str();

    @Test
    void test1() {
        assertEquals("1(2()(5))(3)", o.tree2str(TreeUtils.generateTree13()));
    }

    @Test
    void test2() {
        assertEquals("1(2()(5))(3)", o.tree2str2(TreeUtils.generateTree13()));
    }

    @Test
    void test3() {
        assertEquals("1(2()(5))(3)", o.tree2str3(TreeUtils.generateTree13()));
    }
}