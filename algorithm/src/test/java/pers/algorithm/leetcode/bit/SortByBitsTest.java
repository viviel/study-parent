package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortByBitsTest {

    private final SortByBits o = new SortByBits();

    @Test
    void test1() {
        System.out.println(Arrays.toString(o.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(o.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }

    @Test
    void test2() {
        System.out.println(Arrays.toString(o.sortByBits2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(o.sortByBits2(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }
}
