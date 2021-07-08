package pers.algorithm.leetcode.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountGoodNumbersTest {

    private CountGoodNumbers o;

    @BeforeEach
    void setUp() {
        o = new CountGoodNumbers();
    }

    @Test
    void test1() {
        int r = o.countGoodNumbers(1);
        assertEquals(5, r);
    }

    /**
     * 1: 5
     * 2: 5 * 4
     */
    @Test
    void test2() {
        int r = o.countGoodNumbers(2);
        assertEquals(20, r);
    }

    /**
     * 1: 5
     * 2: 5 * 4
     * 3: 5 * 4 * 5
     */
    @Test
    void test3() {
        int r = o.countGoodNumbers(3);
        assertEquals(100, r);
    }

    /**
     * 1: 5
     * 2: 5 * 4
     * 3: 5 * 4 * 5
     * 4: 5 * 4 * 5 * 4
     */
    @Test
    void test4() {
        int r = o.countGoodNumbers(4);
        assertEquals(400, r);
    }

    /**
     * 12 % 7
     * (5 + 7) % 7
     * <p>
     * (14 * 3) % 11 = 9
     * 14 % 11 = 3
     * 3 % 11 = 3
     */
    @Test
    void test5() {
        int r = o.countGoodNumbers(50);
        assertEquals(564908303, r);
    }
}
