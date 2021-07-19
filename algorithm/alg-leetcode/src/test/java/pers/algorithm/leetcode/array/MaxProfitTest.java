package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MaxProfitTest {

    private MaxProfit o;

    @BeforeEach
    void setUp() {
        o = new MaxProfit();
    }

    @Test
    void test1() {
        int[] inventory = {2, 5};
        int orders = 4;
        int r = o.maxProfit(inventory, orders);
        Assertions.assertEquals(14, r);
    }

    @Test
    void test2() {
        int[] inventory = {3,5};
        int orders = 6;
        int r = o.maxProfit(inventory, orders);
        Assertions.assertEquals(19, r);
    }

    @Test
    void test3() {
        int[] inventory = {2,8,4,10,6};
        int orders = 20;
        int r = o.maxProfit(inventory, orders);
        Assertions.assertEquals(110, r);
    }

    @Test
    void test4() {
        int[] inventory = {1000000000};
        int orders = 1000000000;
        int r = o.maxProfit(inventory, orders);
        Assertions.assertEquals(21, r);
    }

    @Test
    void test5() {
        int[] inventory = {2,8,4,10,6};
        Integer[] array = Arrays.stream(inventory).boxed().toArray(value -> {
            System.out.println(value);
            return new Integer[value];
        });
        System.out.println(Arrays.toString(array));
    }

    @Test
    void test6() {
        long r = 0;
        for (int i = 0; i < 1000000000; i++) {
            r = r + i;
        }
        System.out.println(r);
    }
}
