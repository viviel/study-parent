package pers.algorithm.leetcode.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextGreatestLetterTest {

    private final NextGreatestLetter o = new NextGreatestLetter();

    @Test
    void test1() {
        assertEquals('c', o.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', o.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        assertEquals('f', o.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        assertEquals('c', o.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    @Test
    void test2() {
        System.out.println(o.add1('a'));
        System.out.println(o.add1('z'));
    }


    @Test
    void test3() {
        assertEquals('c', o.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', o.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'c'));
        assertEquals('f', o.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'd'));
        assertEquals('c', o.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'j'));
    }
}