package pers.algorithm.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring o;

    @BeforeEach
    void setUp() {
        o = new LengthOfLongestSubstring();
    }

    @Test
    void t1() {
        int ans = o.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, ans);
    }

    @Test
    void t2() {
        int ans = o.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, ans);
    }

    @Test
    void t3() {
        int ans = o.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, ans);
    }

    @Test
    void t4() {
        int ans = o.lengthOfLongestSubstring("");
        assertEquals(0, ans);
    }

    @Test
    void t5() {
        int ans = o.lengthOfLongestSubstring(" ");
        assertEquals(1, ans);
    }

    @Test
    void t6() {
        int ans = o.lengthOfLongestSubstring("au");
        assertEquals(2, ans);
    }
}
