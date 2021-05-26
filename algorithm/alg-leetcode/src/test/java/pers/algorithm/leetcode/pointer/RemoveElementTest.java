package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {

    private final RemoveElement o = new RemoveElement();

    @Test
    void test1() {
        assertEquals(0, o.removeElement(new int[0], 0));
        assertEquals(2, o.removeElement(new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, o.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        assertEquals(0, o.removeElement(new int[]{1, 1, 1, 1}, 1));
    }
}
