package pers.algorithm.leetcode.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCircleNumTest {

    private FindCircleNum o;

    @BeforeEach
    void setUp() {
        o = new FindCircleNum();
    }

    /**
     * [1,1,0]
     * [1,1,0]
     * [0,0,1]
     */
    @Test
    void test1() {
        int[][] p = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int r = o.findCircleNum(p);
        assertEquals(2, r);
    }

    /**
     * [1,0,0]
     * [0,1,0]
     * [0,0,1]
     */
    @Test
    void test2() {
        int[][] p = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int r = o.findCircleNum(p);
        assertEquals(3, r);
    }
}
