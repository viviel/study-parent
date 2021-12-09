package pers.algorithm.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountAndSayTest {

    private CountAndSay o;

    @BeforeEach
    void setUp() {
        o = new CountAndSay();
    }

    /**
     * f(n) = desc(f(n - 1))
     * <p>
     * f(1) = "1"
     * f(2) = desc("1") = "11"
     * f(3) = desc("11") = "21"
     * f(4) = desc("21") = "1211"
     * f(5) = desc("1211") = "111221"
     */
    @Test
    void test1() {
        String ans = o.desc("1");
        assertEquals("11", ans);
    }

    @Test
    void test2() {
        String ans = o.desc("11");
        assertEquals("21", ans);
    }

    @Test
    void test3() {
        String ans = o.desc("21");
        assertEquals("1211", ans);
    }

    @Test
    void test4() {
        String ans = o.countAndSay(1);
        assertEquals("1", ans);
    }

    @Test
    void test5() {
        String ans = o.countAndSay(2);
        assertEquals("11", ans);
    }

    @Test
    void test6() {
        String ans = o.countAndSay(5);
        assertEquals("111221", ans);
    }
}
