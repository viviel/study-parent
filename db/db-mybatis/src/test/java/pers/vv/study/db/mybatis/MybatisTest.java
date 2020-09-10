package pers.vv.study.db.mybatis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pers.vv.study.db.mybatis.mybatis.Mybatis;

import java.io.IOException;

class MybatisTest {

    private static Mybatis mybatis;

    @BeforeAll
    static void init() throws IOException {
        mybatis = new Mybatis();
    }

    @Test
    void test1() {
        mybatis.test1();
    }

    @Test
    void test2() {
        mybatis.test2();
    }

    @Test
    void test3() {
        mybatis.test3();
    }

    @Test
    void test4() {
        mybatis.test4();
    }

}