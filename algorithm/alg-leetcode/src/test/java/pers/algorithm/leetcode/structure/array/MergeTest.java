package pers.algorithm.leetcode.structure.array;

import org.junit.jupiter.api.Test;

class MergeTest {

    private final Merge o = new Merge();

    @Test
    void test1() {
        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
        o.merge(n1, 3, n2, 3);
    }

    @Test
    void test2() {
        int[] n1 = {1, 0};
        int[] n2 = {};
        o.merge(n1, 1, n2, 0);
    }

    @Test
    void test3() {
        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
        o.merge2(n1, 3, n2, 3);
    }
}
