package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTest {

    private final Add o = new Add();

    @Test
    void test1() {
        assertEquals(2, o.add(1, 1));
    }
}