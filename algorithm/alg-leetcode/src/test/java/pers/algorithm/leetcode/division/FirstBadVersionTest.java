package pers.algorithm.leetcode.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    private final FirstBadVersion o = new FirstBadVersion();

    @Test
    void test1() {
        assertEquals(1702766719, o.firstBadVersion(2126753390));
    }
}