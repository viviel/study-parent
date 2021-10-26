package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsTest {

    private UniquePaths o;

    @BeforeEach
    void setUp() {
        o = new UniquePaths();
    }

    @Test
    void t1() {
        int m = 3, n = 7;
        int ans = o.uniquePaths(m, n);
        assertEquals(28, ans);
    }

    @Test
    void t2() {
        int m = 3, n = 2;
        int ans = o.uniquePaths(m, n);
        assertEquals(3, ans);
    }
}
