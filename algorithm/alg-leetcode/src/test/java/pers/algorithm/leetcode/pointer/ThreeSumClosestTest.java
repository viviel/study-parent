package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumClosestTest {

    private ThreeSumClosest o;

    @BeforeEach
    void setUp() {
        o = new ThreeSumClosest();
    }

    @Test
    void test1() {
        int r = o.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        assertEquals(2, r);
    }

    @Test
    void test2() {
        int r = o.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        assertEquals(2, r);
    }
}
