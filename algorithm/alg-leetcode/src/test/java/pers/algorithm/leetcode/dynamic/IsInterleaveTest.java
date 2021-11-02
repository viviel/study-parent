package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsInterleaveTest {

    private IsInterleave o;

    @BeforeEach
    void setUp() {
        o = new IsInterleave();
    }

    /**
     * aa      bc   c
     *    dbbc    a
     * aa dbbc bc a c
     */
    @Test
    void t1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean ans = o.isInterleave(s1, s2, s3);
        assertTrue(ans);
    }

    /**
     * aa     b cc
     *    dbb ca
     * aa dbb b accc
     */
    @Test
    void t2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean ans = o.isInterleave(s1, s2, s3);
        assertFalse(ans);
    }
}
