package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsAnagramTest {

    private final IsAnagram o = new IsAnagram();

    @Test
    void test1() {
        assertTrue(o.isAnagram("anagram", "nagaram"));
        assertFalse(o.isAnagram("rat", "car"));
    }

    @Test
    void test2() {
        assertTrue(o.isAnagram2("anagram", "nagaram"));
        assertFalse(o.isAnagram2("rat", "car"));
    }

    @Test
    void test3() {
        assertTrue(o.isAnagram3("anagram", "nagaram"));
        assertFalse(o.isAnagram3("rat", "car"));
    }
}