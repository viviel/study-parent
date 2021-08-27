package pers.algorithm.leetcode.divide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSpeedOnTimeTest {

    private MinSpeedOnTime o;

    @BeforeEach
    void setUp() {
        o = new MinSpeedOnTime();
    }

    @Test
    void test1() {
        int[] dist = new int[]{1, 3, 2};
        int speed = 1;
        double duration = o.duration(dist, speed);
        System.out.println(duration);
    }

    @Test
    void test2() {
        int[] dist = new int[]{1, 3, 2};
        int speed = 3;
        double duration = o.duration(dist, speed);
        System.out.println(duration);
    }

    @Test
    void test3() {
        int[] dist = new int[]{1, 3, 2};
        int hour = 6;
        int speed = o.minSpeedOnTime(dist, hour);
        assertEquals(1, speed);
    }

    @Test
    void test4() {
        int[] dist = new int[]{1, 3, 2};
        float hour = 1.9f;
        int speed = o.minSpeedOnTime(dist, hour);
        assertEquals(-1, speed);
    }

    @Test
    void test5() {
        int[] dist = new int[]{1, 1, 100000};
        double hour = 2.01d;
        int speed = o.minSpeedOnTime(dist, hour);
        assertEquals(10000000, speed);
    }

    @Test
    void test6() {
        int[] dist = new int[]{1, 1, 100000};
        double hour = 2.01d;
        double duration = o.duration(dist, 10000000);
        System.out.println(duration < hour);
    }

    @Test
    void test7() {
        int[] dist = new int[]{1, 9};
        double hour = 1.18d;
        int speed = o.minSpeedOnTime(dist, hour);
        assertEquals(50, speed);
    }

    @Test
    void test8() {
        int[] dist = new int[]{1, 9};
        double hour = 1.18d;
        double duration = o.duration(dist, 50);
        System.out.println(duration < hour);
    }
}
