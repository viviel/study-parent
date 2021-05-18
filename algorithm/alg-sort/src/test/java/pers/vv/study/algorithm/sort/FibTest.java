package pers.vv.study.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibTest {

    private final Fib o = new Fib();

    @Test
    void test1() {
        assertEquals(1, o.fib(2));
        assertEquals(5, o.fib(5));
    }

    /**
     * 0 1 2 3 4 5 6  7  8
     * 0 1 1 2 3 5 8 13 21
     */
    @Test
    void test2() {
        assertEquals(1, o.fib2(2));
        assertEquals(5, o.fib2(5));
        assertEquals(13, o.fib2(7));
        assertEquals(21, o.fib2(8));
        assertEquals(134903163, o.fib2(45));
        assertEquals(407059028, o.fib2(95));
    }
}
