package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MassageTest {

    private Massage o;

    @BeforeEach
    void setUp() {
        o = new Massage();
    }

    @Test
    void test1() {
        int r = o.massage(new int[]{1, 2, 3, 1});
        assertEquals(4, r);
    }

    @Test
    void test2() {
        int r = o.massage(new int[]{2, 7, 9, 3, 1});
        assertEquals(12, r);
    }
}
