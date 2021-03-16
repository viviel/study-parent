package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    private RemoveDuplicates o;

    @BeforeEach
    void setUp() {
        o = new RemoveDuplicates();
    }

    @Test
    void test1() {
        assertEquals("ca", o.removeDuplicates("abbaca"));
    }

}
