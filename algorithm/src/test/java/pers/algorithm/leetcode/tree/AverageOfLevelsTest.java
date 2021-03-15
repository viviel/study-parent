package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.tree.common.TreeUtils;

import java.util.List;

class AverageOfLevelsTest {

    private final AverageOfLevels o = new AverageOfLevels();

    @Test
    void test1() {
        List<Double> r = o.averageOfLevels(TreeUtils.generateTree17());
        System.out.println(r);
    }
}