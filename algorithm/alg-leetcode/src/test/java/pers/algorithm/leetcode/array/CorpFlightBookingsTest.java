package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CorpFlightBookingsTest {

    private CorpFlightBookings o;

    @BeforeEach
    void setUp() {
        o = new CorpFlightBookings();
    }

    /**
     * | 1   2   3   4   5
     * | 10  10
     * |     20  20
     * |     25  25  25  25
     * | 10  55  45  25  25
     * |
     * | 差分数组
     * | 0   0   0   0   0
     * | 10  0  -10  0   0
     * | 10  20 -10 -20  0
     * | 10  45 -10 -20  0
     */
    @Test
    void test1() {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] ans = o.corpFlightBookings(bookings, n);
    }
}
