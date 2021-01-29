package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DecodeTest {

    private final Decode o = new Decode();

    @Test
    void test1() {
        System.out.println(Arrays.toString(o.decode(new int[]{1, 2, 3}, 1)));
    }
}