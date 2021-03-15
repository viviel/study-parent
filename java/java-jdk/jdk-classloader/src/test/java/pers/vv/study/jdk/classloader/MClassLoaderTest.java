package pers.vv.study.jdk.classloader;

import org.junit.jupiter.api.Test;

class MClassLoaderTest {

    private final MClassLoader o = new MClassLoader();

    @Test
    void test1() {
        o.systemClassLoader();
        o.commonClassLoader();
    }

    @Test
    void test2() {
        o.extClassLoader();
    }

    @Test
    void test3() {
        o.boostrapClassLoader();
    }

    @Test
    void test4() {
        o.contextClassLoader();
    }

    @Test
    void test5() {
        o.load();
    }
}
