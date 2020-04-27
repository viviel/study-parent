package pers.vv.study.db.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Main main;

    @BeforeAll
    static void before() throws SQLException {
        main = new Main();
    }

    @Test
    void test1() {
        Assertions.assertDoesNotThrow(main::test1);
    }

}