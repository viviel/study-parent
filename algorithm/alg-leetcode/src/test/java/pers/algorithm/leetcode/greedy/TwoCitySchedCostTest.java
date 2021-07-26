package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoCitySchedCostTest {

    private TwoCitySchedCost o;

    @BeforeEach
    void setUp() {
        o = new TwoCitySchedCost();
    }

    /**
     * [
     * [259,770],
     * [448,54],
     * [926,667],
     * [184,139],
     * [840,118],
     * [577,469]
     * ]
     */
    @Test
    void test1() {
        int[][] p = new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int r = o.twoCitySchedCost(p);
        assertEquals(1859, r);
    }
}
