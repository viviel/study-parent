package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobTest {

    private Rob o;

    @BeforeEach
    void setUp() {
        o = new Rob();
    }

    /**
     * 1,2,3,1
     */
    @Test
    void t1() {
        int[] nums = new int[]{1, 2, 3, 1};
        int ans = o.rob(nums);
        assertEquals(4, ans);
    }

    /**
     * 2,7,9,3,1
     * <p>
     * 2
     * 2
     * <p>
     * 2 7
     * 7
     * <p>
     * 2 7 9
     * 11
     * <p>
     * 2 7 9 3
     * 11
     * <p>
     * 2 7 9 3 1
     * 12
     */
    @Test
    void t2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int ans = o.rob(nums);
        assertEquals(12, ans);
    }
}
