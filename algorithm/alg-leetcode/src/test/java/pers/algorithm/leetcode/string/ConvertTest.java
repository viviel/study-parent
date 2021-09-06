package pers.algorithm.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    private Convert o;

    @BeforeEach
    void setUp() {
        o = new Convert();
    }

    @Test
    void test1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String ans = o.convert(s, numRows);
        assertEquals("PAHNAPLSIIGYIR", ans);
    }
}
