package pers.algorithm.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntToRomanTest {

    private IntToRoman o;

    @BeforeEach
    void setUp() {
        o = new IntToRoman();
    }

    @Test
    void test1() {
        int num = 3;
        String ans = o.intToRoman(num);
        assertEquals("III", ans);
    }

    @Test
    void test2() {
        int num = 4;
        String ans = o.intToRoman(num);
        assertEquals("IV", ans);
    }

    @Test
    void test3() {
        int num = 9;
        String ans = o.intToRoman(num);
        assertEquals("IX", ans);
    }

    @Test
    void test4() {
        int num = 58;
        String ans = o.intToRoman(num);
        assertEquals("LVIII", ans);
    }

    @Test
    void test5() {
        int num = 1994;
        String ans = o.intToRoman(num);
        assertEquals("MCMXCIV", ans);
    }
}
