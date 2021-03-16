package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindComplementTest {

    private final FindComplement o = new FindComplement();

    @Test
    void test1() {
        assertEquals(2, o.findComplement(5));
        assertEquals(0, o.findComplement(1));
        assertEquals(0, o.findComplement(0));
    }
}
