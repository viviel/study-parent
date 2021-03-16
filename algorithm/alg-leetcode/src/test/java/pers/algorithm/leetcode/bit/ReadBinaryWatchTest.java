package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import java.util.List;

class ReadBinaryWatchTest {

    private final ReadBinaryWatch o = new ReadBinaryWatch();

    @Test
    void test1() {
        List<String> list = o.readBinaryWatch(1);
        System.out.println(list);
    }
}
