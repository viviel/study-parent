package pers.vv.study.jdk.syntax;

import org.junit.jupiter.api.Test;

class UnsafeArrayTest {

    @Test
    void test1() {
        int arraySize = 1024;
        UnsafeArray array = new UnsafeArray(arraySize);
        System.out.println("Array size:" + array.size());
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set(i, (byte) 3);
            sum += array.get(i);
        }
        System.out.println(sum);
    }

    @Test
    void test2() {
        UnsafeArray array = new UnsafeArray(10);
        array.set(Integer.MAX_VALUE >> 7, (byte) 3);
        array.set(Integer.MAX_VALUE >> 1, (byte) 3);
        array.set(Integer.MAX_VALUE, (byte) 3);
    }
}
