package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanReachTest {

    private CanReach o;

    @BeforeEach
    void setUp() {
        o = new CanReach();
    }

    @Test
    void test1() {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        boolean r = o.canReach(s, minJump, maxJump);
        assertTrue(r);
    }

    @Test
    void test2() {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        boolean r = o.canReach(s, minJump, maxJump);
        assertFalse(r);
    }
}
