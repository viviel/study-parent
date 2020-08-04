package pers.vv.study.db.mybatis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {

    private static Main main;

    @BeforeAll
    static void init() throws IOException {
        main = new Main();
    }

    @Test
    void test2() {
        main.test2();
    }

    @Test
    void test3() {
        main.test3();
    }
    
    @Test
    void test5() {
        main.test5();
    }

}