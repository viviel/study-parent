package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPalindromeFormationTest {

    private CheckPalindromeFormation o;

    @BeforeEach
    void setUp() {
        o = new CheckPalindromeFormation();
    }

    @Test
    void test() {
        assertTrue(o.check("abcba"));
        assertTrue(o.check("abccba"));
        assertFalse(o.check("abccbad"));
    }

    @Test
    void test1() {
        String a = "abdef";
        String b = "fecab";
        boolean ans = o.checkPalindromeFormation(a, b);
        assertTrue(ans);
    }

    @Test
    void test2() {
        String a = "ulacfd";
        String b = "jizalu";
        boolean ans = o.checkPalindromeFormation(a, b);
        assertTrue(ans);
    }

    @Test
    void test3() {
        String a = "xbdef";
        String b = "xecab";
        boolean ans = o.checkPalindromeFormation(a, b);
        assertFalse(ans);
    }

    @Test
    void test4() {
        String a = "aabccba";
        String b = "zbcdcba";
        boolean ans = o.checkPalindromeFormation(a, b);
        assertTrue(ans);
    }
}
