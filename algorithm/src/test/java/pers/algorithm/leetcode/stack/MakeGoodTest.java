package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeGoodTest {

    private final MakeGood o = new MakeGood();

    @Test
    void test1() {
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        System.out.println('a' - 'A');
        System.out.println((int) 'b');
        System.out.println((int) 'B');
        System.out.println('b' - 'B');
    }

    @Test
    void test2() {
        assertEquals("leetcode", o.makeGood("leEeetcode"));
        assertEquals("", o.makeGood("abBAcC"));
    }

}
