package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumTimesAllBlueTest {

    private NumTimesAllBlue o;

    @BeforeEach
    void setUp() {
        o = new NumTimesAllBlue2();
    }

    @Test
    void test1() {
        int[] light = new int[]{2, 1, 3, 5, 4};
        int ans = o.numTimesAllBlue(light);
        assertEquals(3, ans);
    }

    @Test
    void test2() {
        int[] light = new int[]{3, 2, 4, 1, 5};
        int ans = o.numTimesAllBlue(light);
        assertEquals(2, ans);
    }

    @Test
    void test3() {
        int[] light = new int[]{4, 1, 2, 3};
        int ans = o.numTimesAllBlue(light);
        assertEquals(1, ans);
    }

    @Test
    void test4() {
        int[] light = new int[]{2, 1, 4, 3, 6, 5};
        int ans = o.numTimesAllBlue(light);
        assertEquals(3, ans);
    }

    @Test
    void test5() {
        int[] light = new int[]{1, 2, 3, 4, 5, 6};
        int ans = o.numTimesAllBlue(light);
        assertEquals(6, ans);
    }
}
