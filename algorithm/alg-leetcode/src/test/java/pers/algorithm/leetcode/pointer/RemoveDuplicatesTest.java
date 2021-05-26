package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    private final RemoveDuplicates o = new RemoveDuplicates();

    @Test
    void test1() {
        assertEquals(0, o.removeDuplicates(new int[0]));
        assertEquals(1, o.removeDuplicates(new int[]{1}));
        assertEquals(2, o.removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(5, o.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
