package pers.vv.study.util;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class StreamTest {

    @Test
    void test1() {
        IntStream.range(0, 1000).forEach(System.out::println);
    }
}
