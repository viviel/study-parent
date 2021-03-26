package pers.algorithm.leetcode.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPerfectSquareTest {

    private final IsPerfectSquare o = new IsPerfectSquare();

    @Test
    void test1() {
        assertTrue(o.isPerfectSquare(16));
        assertFalse(o.isPerfectSquare(14));
        assertTrue(o.isPerfectSquare(1));
        assertFalse(o.isPerfectSquare((1 << 31) - 1));
    }
}