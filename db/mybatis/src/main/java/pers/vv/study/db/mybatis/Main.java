package pers.vv.study.db.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    private static final String resource = "mybatisConfig.xml";
    private final SqlSessionFactory sqlSessionFactory;

    public Main() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args) throws IOException {
        new Main().test2();
    }

    public void test1() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> users = session.selectList("user.listAll");
            users.forEach(System.out::println);
        }
    }

    public void test2() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setName("test2");
            int count = session.insert("user.insert", user);
            System.out.println(count);
        }
    }

}
