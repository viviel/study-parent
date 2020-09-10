package pers.vv.study.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {

    private final Connection conn;

    public JDBC() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
    }

    public void test1() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into user0(name) values (?)");
        ps.setString(1, "setstring");

        ps.execute();
    }

}
