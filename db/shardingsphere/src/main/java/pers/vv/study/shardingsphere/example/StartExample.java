package pers.vv.study.shardingsphere.example;

import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author guoshixiong
 */
public class StartExample {

    public static void main(String[] args) {

    }

    public void beginUse() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        Properties props = new Properties();

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, props);
    }

}
