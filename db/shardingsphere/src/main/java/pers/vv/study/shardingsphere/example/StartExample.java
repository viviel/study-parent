package pers.vv.study.shardingsphere.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author guoshixiong
 */
public class StartExample {

    public static void main(String[] args) throws SQLException {
        new StartExample().beginUse();
    }

    public void beginUse() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1234");
        dataSourceMap.put("test", mysqlDataSource);

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        TableRuleConfiguration userTableRuleConfig = new TableRuleConfiguration(
                "user", "test.user${0..1}"
        );
        userTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration(
                "id", "user{id % 2}"
        ));

        shardingRuleConfig.getTableRuleConfigs().add(userTableRuleConfig);

        Properties props = new Properties();

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, props);

        Connection connection = dataSource.getConnection();

        insert(connection);
    }

    private void insert(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("insert into user(id, name) values (1, 'vv')");
    }

    private void select(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM user0");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
        }
    }

}
