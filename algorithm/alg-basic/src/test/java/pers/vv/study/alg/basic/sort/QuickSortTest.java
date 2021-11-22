package pers.vv.study.alg.basic.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    private Sort o;

    @BeforeEach
    void setUp() {
        o = new QuickSort();
    }

    /**
     * 1,2,3,4,5,6
     * 2,1,3,4,5,6
     */
    @Test
    void t1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        o.sort(nums);
    }

    /**
     * 4,1,6,2,5,3
     * 4,1,3,2,5,6
     */
    @Test
    void t2() {
        int[] nums = new int[]{4, 1, 6, 2, 5, 3};
        o.sort(nums);
    }

    /**
     * 6, 5, 4, 3, 2, 1
     */
    @Test
    void t3() {
        int[] nums = new int[]{6, 5, 4, 3, 2, 1};
        o.sort(nums);
    }
}
