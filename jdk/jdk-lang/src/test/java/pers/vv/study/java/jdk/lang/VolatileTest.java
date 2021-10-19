package pers.vv.study.java.jdk.lang;

import org.junit.jupiter.api.Test;

public class VolatileTest {

    private volatile int a;

    @Test
    void test1() {
        int b;
        b = a;
    }
}
