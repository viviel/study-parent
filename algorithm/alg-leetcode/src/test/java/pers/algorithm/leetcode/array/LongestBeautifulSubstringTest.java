package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestBeautifulSubstringTest {

    private LongestBeautifulSubstring o;

    @BeforeEach
    void setUp() {
        o = new LongestBeautifulSubstring();
    }

    @Test
    void test1() {
        String p = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        int r = o.longestBeautifulSubstring(p);
        assertEquals(13, r);
    }

    @Test
    void test2() {
        String p = "aeeeiiiioooauuuaeiou";
        int r = o.longestBeautifulSubstring(p);
        assertEquals(5, r);
    }

    @Test
    void test3() {
        String p = "a";
        int r = o.longestBeautifulSubstring(p);
        assertEquals(0, r);
    }

    @Test
    void test4() {
        String p = "aaaaa";
        int r = o.longestBeautifulSubstring(p);
        assertEquals(0, r);
    }
}
