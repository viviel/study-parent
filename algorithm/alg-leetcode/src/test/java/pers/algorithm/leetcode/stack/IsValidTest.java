package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsValidTest {

    private final IsValid o = new IsValid();

    @Test
    void test1() {
        assertFalse(o.isValid(null));
        assertFalse(o.isValid("{"));
        assertFalse(o.isValid("}"));
        assertTrue(o.isValid("{}"));
    }
}
