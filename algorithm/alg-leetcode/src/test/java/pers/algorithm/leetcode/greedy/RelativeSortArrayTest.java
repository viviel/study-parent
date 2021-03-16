package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RelativeSortArrayTest {

    private final RelativeSortArray o = new RelativeSortArray();

    @Test
    void test1() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        assertArrayEquals(result, o.relativeSortArray(arr1, arr2));
    }

    @Test
    void test2() {
        int[] arr1 = {26, 21, 11, 20, 50, 34, 1, 18};
        int[] arr2 = {21, 11, 26, 20};
        int[] result = {21, 11, 26, 20, 1, 18, 34, 50};
        assertArrayEquals(result, o.relativeSortArray(arr1, arr2));
    }

    @Test
    void test3() {
        int[] arr1 = {26, 21, 11, 20, 50, 34, 1, 18};
        int[] arr2 = {21, 11, 26, 20};
        int[] result = {21, 11, 26, 20, 1, 18, 34, 50};
        assertArrayEquals(result, o.relativeSortArray2(arr1, arr2));
    }

    /**
     * [2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
     * [2,42,38,0,43,21]
     * [2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]
     */
    @Test
    void test4() {
        int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = {2, 42, 38, 0, 43, 21};
        int[] result = {2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48};
        assertArrayEquals(result, o.relativeSortArray3(arr1, arr2));
    }
}