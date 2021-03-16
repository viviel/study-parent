package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSubsequenceTest {

    private final IsSubsequence o = new IsSubsequence();

    @Test
    void test1() {
        assertTrue(o.isSubsequence("abc", "ahbgdc"));
        assertFalse(o.isSubsequence("axc", "ahbgdc"));
    }
}
