package pers.vv.jdk.syntax;

import org.junit.jupiter.api.Test;

public class MTest {

    private final static int i = 0;

    static class C {
        private void m1() {
            System.out.println(i);
        }
    }

    @Test
    void test1() {
        System.out.println(0x7fff);
    }

    @Test
    void test2() {
        System.out.println(1 << 31);
        System.out.println(Integer.toBinaryString(1 << 31));
    }

}
