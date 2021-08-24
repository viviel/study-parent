package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCheapestPriceTest {

    private FindCheapestPrice o;

    @BeforeEach
    void setUp() {
        o = new FindCheapestPrice();
    }

    @Test
    void test1() {
        int n = 3;
        int[][] flights = new int[][]{{1, 2, 100}, {0, 1, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int ans = o.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(200, ans);
    }

    @Test
    void test2() {
        int n = 3;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 0;
        int ans = o.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(500, ans);
    }
}
