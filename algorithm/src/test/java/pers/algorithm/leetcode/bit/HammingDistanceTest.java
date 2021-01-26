package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {

    private final HammingDistance o = new HammingDistance();

    @Test
    void test() {
        assertEquals(2, o.hammingDistance(1, 4));
    }
}