package pers.algorithm.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DivingBoardTest {

    private final DivingBoard o = new DivingBoard();

    @Test
    void test1() {
        int[] r = o.divingBoard(1, 2, 3);
        System.out.println(Arrays.toString(r));
    }

    @Test
    void test2() {
        int[] r = o.divingBoard(1, 1, 100000);
        assertArrayEquals(new int[0], r);
    }
}
