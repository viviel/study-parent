package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheDifferenceTest {

    private final FindTheDifference o = new FindTheDifference();

    @Test
    void test1() {
        assertEquals('e', o.findTheDifference("abcd", "abcde"));
        assertEquals('e', o.findTheDifference("abcd", "abecd"));
        assertEquals('a', o.findTheDifference("abcd", "aabcd"));
        assertEquals('y', o.findTheDifference("", "y"));
        assertEquals('y', o.findTheDifference("", "y"));
    }

    @Test
    void test2() {
        assertEquals('e', o.findTheDifference2("abcd", "abcde"));
        assertEquals('e', o.findTheDifference2("abcd", "abecd"));
        assertEquals('a', o.findTheDifference2("abcd", "aabcd"));
        assertEquals('y', o.findTheDifference2("", "y"));
        assertEquals('y', o.findTheDifference2("", "y"));
    }

    @Test
    void test3() {
        assertEquals('e', o.findTheDifference3("abcd", "abcde"));
        assertEquals('e', o.findTheDifference3("abcd", "abecd"));
        assertEquals('a', o.findTheDifference3("abcd", "aabcd"));
        assertEquals('y', o.findTheDifference3("", "y"));
        assertEquals('y', o.findTheDifference3("", "y"));
    }
}
