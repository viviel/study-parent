package pers.vv.study.db.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class JDBCTest {

    private static JDBC JDBC;

    @BeforeAll
    static void before() throws SQLException {
        JDBC = new JDBC();
    }

    @Test
    void test1() {
        Assertions.assertDoesNotThrow(JDBC::test1);
    }

    @Test
    void test2() {
    }

}