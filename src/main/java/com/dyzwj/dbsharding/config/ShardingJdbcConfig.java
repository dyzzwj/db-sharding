package com.dyzwj.dbsharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName ShardingJdbcConfig.java
 * @Description TODO
 * @createTime 2020年04月30日 15:17:00
 */
//@Configuration
public class ShardingJdbcConfig {

    static {
        a = 2;
    }

    {
        b = 0;
    }

    private static int a = 1;

    private int b = 2;

    public static void main(String[] args) {
        ShardingJdbcConfig config = new ShardingJdbcConfig();
        System.out.println(ShardingJdbcConfig.a);
        System.out.println(config.b);
    }

    //定义sharding-jdbc数据源
    @Bean
    public DataSource getShardingDataSource() throws SQLException {

        ShardingRuleConfiguration configuration = new ShardingRuleConfiguration();
        configuration.getTableRuleConfigs().add(tableRuleConfiguration());
        Properties properties = new Properties();
        properties.setProperty("sql.show","true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(),configuration,properties);
    }


    //定义数据源
    public Map<String,DataSource> createDataSourceMap(){
        Map<String,DataSource> result = new HashMap<>();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/order_db?useUnicode=true&characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("dyzwj");
        System.out.println(dataSource);
        result.put("db1",dataSource);
        return result;

    }


    //定义主键生成策略
    public KeyGeneratorConfiguration keyGeneratorConfiguration(){
        return new KeyGeneratorConfiguration("SNOWFLAKE","order_id");
    }

    //定义分表策略
    public TableRuleConfiguration tableRuleConfiguration(){

        //数据源的分布情况
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration("t_order","db1.t_order_$->{1..2}");
        tableRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id","t_order_$->{ order_id % 2 +1 }"));
        tableRuleConfiguration.setKeyGeneratorConfig(keyGeneratorConfiguration());
        return tableRuleConfiguration;

    }





}
