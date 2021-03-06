package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsLongPressedNameTest {

    private IsLongPressedName o;

    @BeforeEach
    void setUp() {
        o = new IsLongPressedName();
    }

    @Test
    void test1() {
        assertTrue(o.isLongPressedName("alex", "aaleex"));
        assertFalse(o.isLongPressedName("saeed", "ssaaedd"));
        assertFalse(o.isLongPressedName("alex", "aaleexa"));
        assertFalse(o.isLongPressedName("pyplrz", "ppyypllr"));
    }
}
