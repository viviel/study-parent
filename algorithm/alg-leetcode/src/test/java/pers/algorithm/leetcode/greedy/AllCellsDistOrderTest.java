package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AllCellsDistOrderTest {

    private final AllCellsDistOrder o = new AllCellsDistOrder();

    @Test
    void test1() {
        System.out.println(Arrays.deepToString(o.allCellsDistOrder(2, 3, 1, 2)));
    }

    @Test
    void test2() {
        System.out.println(Arrays.deepToString(o.allCellsDistOrder2(2, 3, 1, 2)));
    }

    @Test
    void test3() {
        System.out.println(Arrays.deepToString(o.allCellsDistOrder3(2, 3, 1, 2)));
    }
}