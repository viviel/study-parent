package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipGameTest {

    private FlipGame o;

    @BeforeEach
    void setUp() {
        o = new FlipGame();
    }

    @Test
    void test1() {
        int[] a1 = {1, 2, 4, 4, 7};
        int[] a2 = {1, 3, 4, 1, 3};
        int r = o.flipgame(a1, a2);
        assertEquals(2, r);
    }

    @Test
    void test2() {
        int[] a1 = {1, 4, 4, 7};
        int[] a2 = {1, 4, 1, 3};
        int r = o.flipgame(a1, a2);
        assertEquals(3, r);
    }
}
