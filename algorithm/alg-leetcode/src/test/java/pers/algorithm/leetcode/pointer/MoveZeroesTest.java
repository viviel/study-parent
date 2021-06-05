package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoveZeroesTest {

    private MoveZeroes o;

    @BeforeEach
    void setUp() {
        o = new MoveZeroes();
    }

    @Test
    void test1() {
        int[] array = {0, 1, 0, 3, 12};
        o.moveZeroes(array);
    }

    @Test
    void test2() {
        int[] array = {1, 0};
        o.moveZeroes(array);
    }

    @Test
    void test3() {
        int[] array = {1, 0, 1};
        o.moveZeroes(array);
    }

    @Test
    void test4() {
        int[] array = {1, 0, 1};
        o.moveZeroes2(array);
    }
}
