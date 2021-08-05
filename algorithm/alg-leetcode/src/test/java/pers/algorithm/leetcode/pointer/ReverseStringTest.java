package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

    private ReverseString o;

    @BeforeEach
    void setUp() {
        o = new ReverseString();
    }

    @Test
    void test1() {
        char[] cs = {'a', 'b'};
        o.reverseString(cs);
    }
}
