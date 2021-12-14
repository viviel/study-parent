package pers.algorithm.leetcode.structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    private LongestPalindrome o;

    @BeforeEach
    void setUp() {
        o = new LongestPalindrome();
    }

    @Test
    void t1() {
        String ans = o.longestPalindrome("babad");
        assertEquals("bab", ans);
    }

    @Test
    void t2() {
        String ans = o.longestPalindrome("cbbd");
        assertEquals("bb", ans);
    }

    @Test
    void t3() {
        String ans = o.longestPalindrome("a");
        assertEquals("a", ans);
    }
}
