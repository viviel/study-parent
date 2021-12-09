package pers.algorithm.leetcode.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AllPathsSourceTargetTest {

    private AllPathsSourceTarget o;

    @BeforeEach
    void setUp() {
        o = new AllPathsSourceTarget();
    }

    @Test
    void test1() {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> ans = o.allPathsSourceTarget(graph);
    }

    @Test
    void test2() {
        int[][] graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> ans = o.allPathsSourceTarget(graph);
    }
}
