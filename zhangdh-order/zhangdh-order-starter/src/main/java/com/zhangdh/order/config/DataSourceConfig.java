package com.zhangdh.order.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.xa.DataSourceProxyXA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;


/**
 * @author yinshi
 * @date 2024/4/1
 * @apiNote
 */
@Configuration
public class DataSourceConfig {
    //    XA事务
    @Bean("dataSourceProxy")
    @Order
    public DataSource getDataSource(HikariDataSource hikariDataSource){
        return new DataSourceProxyXA(hikariDataSource);
    }
}
