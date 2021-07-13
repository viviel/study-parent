package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GenerateMatrixTest {

    private GenerateMatrix o;

    @BeforeEach
    void setUp() {
        o = new GenerateMatrix();
    }

    @Test
    void test1() {
        int[][] r = o.generateMatrix(1);
        System.out.println(Arrays.deepToString(r));
    }

    @Test
    void test2() {
        int[][] r = o.generateMatrix(2);
        System.out.println(Arrays.deepToString(r));
    }

    @Test
    void test3() {
        int[][] r = o.generateMatrix(3);
        System.out.println(Arrays.deepToString(r));
    }

    @Test
    void test4() {
        int[][] r = o.generateMatrix(4);
        System.out.println(Arrays.deepToString(r));
    }

    @Test
    void test5() {
        int[][] r = o.generateMatrix(5);
        System.out.println(Arrays.deepToString(r));
    }
}
