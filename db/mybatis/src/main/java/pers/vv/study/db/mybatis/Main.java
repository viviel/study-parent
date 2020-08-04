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
        createTable();
    }
    
    public static void main(String[] args) {
        try {
            new Main().test1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createTable() {
        sqlSessionFactory.openSession().update("createTable");
    }

    public void test1() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> users = session.selectList("user.listAll");
            users.forEach(System.out::println);
        }
    }

    /**
     * 使用insert必须显示调用提交事务方法
     */
    public void test2() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setName("test2");
            int count = session.insert("user.insert", user);
            session.commit();

            System.out.println(count);
        }
    }

    public void test3() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user = new User();
            user.setName("test2");
            int count = session.insert("user.insertNotExist", user);
            session.commit();

            System.out.println(count);
        }
    }

}
