package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import java.util.List;

class BinaryTreePathsTest {

    private final BinaryTreePaths o = new BinaryTreePaths();

    @Test
    void test1() {
        List<String> result = o.binaryTreePaths(TreeUtils.generateTree13());
        System.out.println(result);
    }
}
