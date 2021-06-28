package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsTest {

    private ReverseWords o;

    @BeforeEach
    void setUp() {
        o = new ReverseWords();
    }

    @Test
    void test1() {
        String r = o.reverseWords("the sky is blue");
        assertEquals("blue is sky the", r);
        System.out.println(r);
    }

    @Test
    void test2() {
        String r = o.reverseWords("");
        System.out.println(r);
    }

    @Test
    void test3() {
        String r = o.reverseWords(" ");
        System.out.println(r);
    }

    @Test
    void test4() {
        String r = o.reverseWords("  hello world  ");
        System.out.println(r);
    }

    @Test
    void test5() {
        String r = o.reverseWords("a good   example");
        System.out.println(r);
    }
}
