package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotSimTest {

    private final RobotSim o = new RobotSim();

    @Test
    void test1() {
        assertEquals(0, o.robotSim(new int[]{}, new int[][]{}));
    }
}