package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextPermutationTest {

    private NextPermutation o;

    @BeforeEach
    void setUp() {
        o = new NextPermutation();
    }

    @Test
    void test1() {
        int[] p = new int[]{1, 2, 3};
        int[] t = new int[]{1, 3, 2};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test2() {
        int[] p = new int[]{1, 3, 2};
        int[] t = new int[]{2, 1, 3};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test3() {
        int[] p = new int[]{2, 3, 1};
        int[] t = new int[]{3, 1, 2};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test4() {
        int[] p = new int[]{3, 2, 1};
        int[] t = new int[]{1, 2, 3};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test5() {
        int[] p = new int[]{3, 2, 1};
        int[] t = new int[]{3, 1, 2};
        Arrays.sort(p, 1, 3);
        assertArrayEquals(t, p);
    }

    @Test
    void test6() {
        int[] p = new int[]{1, 1, 5};
        int[] t = new int[]{1, 5, 1};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test7() {
        int[] p = new int[]{1};
        int[] t = new int[]{1};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test8() {
        int[] p = new int[]{1, 3, 2};
        int[] t = new int[]{2, 1, 3};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }

    @Test
    void test9() {
        int[] p = new int[]{4, 2, 0, 2, 3, 2, 0};
        int[] t = new int[]{4, 2, 0, 3, 0, 2, 2};
        o.nextPermutation(p);
        assertArrayEquals(t, p);
    }
}
