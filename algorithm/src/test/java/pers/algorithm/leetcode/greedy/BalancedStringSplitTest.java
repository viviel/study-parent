package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedStringSplitTest {

    private final BalancedStringSplit o = new BalancedStringSplit();

    @Test
    void test1() {
        assertEquals(4, o.balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, o.balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, o.balancedStringSplit("LLLLRRRR"));
    }
}