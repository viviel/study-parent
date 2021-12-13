package pers.algorithm.leetcode.structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringsTest {

    private AddStrings o;

    @BeforeEach
    void setUp() {
        o = new AddStrings();
    }

    @Test
    void t1() {
        String num1 = "123";
        String num2 = "1";
        String ans = o.addStrings(num1, num2);
        assertEquals("124", ans);
    }

    @Test
    void t2() {
        String num1 = "99";
        String num2 = "1";
        String ans = o.addStrings(num1, num2);
        assertEquals("100", ans);
    }

    /**
     * 9999999999999999
     * 0000000000000000
     */
    @Test
    void t3() {
        String num1 = "9999999999999999";
        String num2 = "1";
        String ans = o.addStrings(num1, num2);
        assertEquals("10000000000000000", ans);
    }
}
