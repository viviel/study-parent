package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareVersionTest {

    private CompareVersion o;

    @BeforeEach
    void setUp() {
        o = new CompareVersion();
    }

    @Test
    void test1() {
        String version1 = "1.01";
        String version2 = "1.001";
        int ans = o.compareVersion(version1, version2);
        assertEquals(0, ans);
    }

    @Test
    void test2() {
        String version1 = "1.1";
        String version2 = "1.1.0";
        int ans = o.compareVersion(version1, version2);
        assertEquals(0, ans);
    }

    @Test
    void test3() {
        String version1 = "0.1";
        String version2 = "1.1";
        int ans = o.compareVersion(version1, version2);
        assertEquals(-1, ans);
    }

    @Test
    void test4() {
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        int ans = o.compareVersion(version1, version2);
        assertEquals(-1, ans);
    }
}
