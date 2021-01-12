package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingWeightTest {

    private final HammingWeight o = new HammingWeight();

    @Test
    void test() {
        assertEquals(2, o.hammingWeight(3));
        assertEquals(3, o.hammingWeight(7));
    }
}