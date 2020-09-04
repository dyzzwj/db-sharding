package com.dyzwj.dbsharding;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class
//                                    , SpringBootConfiguration.class})
@SpringBootApplication(
        exclude = {
                DruidDataSourceAutoConfigure.class
        }
)
public class DbShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbShardingApplication.class, args);
    }

}
