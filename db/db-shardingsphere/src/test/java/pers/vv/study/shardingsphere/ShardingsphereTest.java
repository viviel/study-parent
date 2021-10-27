package pers.vv.study.shardingsphere;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ShardingsphereTest {

    @Test
    void t1() throws SQLException {
        Map<String, DataSource> dataSourceMap = getDSMap();
        ShardingRuleConfiguration shardingRuleConfig = getShardingRuleConfiguration();
        Properties properties = new Properties();
        DataSource ds = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
        Connection con = ds.getConnection();
        insert(con);
        select(con);
    }

    private Map<String, DataSource> getDSMap() {
        Map<String, DataSource> dsMap = new HashMap<>();
        dsMap.put("test", getDataSource());
        return dsMap;
    }

    private DataSource getDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        ds.setUser("root");
        ds.setPassword("1234");
        return ds;
    }

    private ShardingRuleConfiguration getShardingRuleConfiguration() {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        TableRuleConfiguration tableRuleConfig = new TableRuleConfiguration(
                "user", "test.user${0..1}"
        );
        tableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration(
                "id", "user${id % 2}"
        ));
        shardingRuleConfig.getTableRuleConfigs().add(tableRuleConfig);
        return shardingRuleConfig;
    }

    private void insert(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        for (int i = 0; i < 10; i++) {
            String sql = String.format("insert into user(id, name) values (%s, 'vv')", i + 1);
            stmt.execute(sql);
        }
    }

    private void select(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM user");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
        }
    }
}
