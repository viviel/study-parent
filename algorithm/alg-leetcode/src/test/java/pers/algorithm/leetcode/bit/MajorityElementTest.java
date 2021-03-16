package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {

    private final MajorityElement o = new MajorityElement();

    @Test
    void test1() {
        assertEquals(3, o.majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, o.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void test2() {
        assertEquals(3, o.majorityElement2(new int[]{3, 2, 3}));
        assertEquals(2, o.majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}