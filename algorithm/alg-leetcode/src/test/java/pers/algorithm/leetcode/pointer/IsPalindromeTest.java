package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {

    private IsPalindrome o;

    @BeforeEach
    void setUp() {
        o = new IsPalindrome();
    }

    @Test
    void test1() {
        String s = "1".toLowerCase();
        assertEquals("1", s);
    }

    @Test
    void test2() {
        boolean r = o.isPalindrome("A man, a plan, a canal: Panama");
        assertTrue(r);
    }

    @Test
    void test3() {
        boolean r = o.isPalindrome("race a car");
        assertFalse(r);
    }

    @Test
    void test4() {
        boolean r = o.isPalindrome("0P");
        assertFalse(r);
    }
}
