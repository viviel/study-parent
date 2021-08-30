package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuessNumberTest {

    private final GuessNumber o = new GuessNumber();

    @Test
    void test1() {
        assertEquals(6, o.guessNumber(10));
    }
}