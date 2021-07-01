package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinFibonacciNumbersTest {

    private FindMinFibonacciNumbers o;

    @BeforeEach
    void setUp() {
        o = new FindMinFibonacciNumbers();
    }

    @Test
    void test1() {
        int r = o.findMinFibonacciNumbers(7);
        assertEquals(2, r);
    }

    @Test
    void test2() {
        int r = o.findMinFibonacciNumbers(10);
        assertEquals(2, r);
    }

    @Test
    void test3() {
        int r = o.findMinFibonacciNumbers(19);
        assertEquals(3, r);
    }
}
