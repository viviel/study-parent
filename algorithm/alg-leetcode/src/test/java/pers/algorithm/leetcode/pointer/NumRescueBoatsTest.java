package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumRescueBoatsTest {

    private NumRescueBoats o;

    @BeforeEach
    void setUp() {
        o = new NumRescueBoats();
    }

    @Test
    void test1() {
        int[] people = new int[]{2, 1};
        int limit = 3;
        int ans = o.numRescueBoats(people, limit);
        assertEquals(1, ans);
    }

    @Test
    void test2() {
        int[] people = new int[]{3, 2, 2, 1};
        int limit = 3;
        int ans = o.numRescueBoats(people, limit);
        assertEquals(3, ans);
    }

    @Test
    void test3() {
        int[] people = new int[]{5, 4, 3, 3};
        int limit = 5;
        int ans = o.numRescueBoats(people, limit);
        assertEquals(4, ans);
    }
}
