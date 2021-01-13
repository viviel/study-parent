package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    private final MissingNumber o = new MissingNumber();

    @Test
    void test1() {
        assertEquals(2, o.missingNumber(new int[]{3, 0, 1}));
        assertEquals(8, o.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    @Test
    void test2() {
        assertEquals(2, o.missingNumber2(new int[]{3, 0, 1}));
        assertEquals(8, o.missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}