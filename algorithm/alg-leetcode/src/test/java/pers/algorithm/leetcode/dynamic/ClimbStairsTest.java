package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbStairsTest {

    private ClimbStairs o;

    @BeforeEach
    void setUp() {
        o = new ClimbStairs();
    }

    @Test
    void test1() {
        assertEquals(1, o.climbStairs(0));
        assertEquals(1, o.climbStairs(1));
        assertEquals(2, o.climbStairs(2));
        assertEquals(3, o.climbStairs(3));
    }
}
