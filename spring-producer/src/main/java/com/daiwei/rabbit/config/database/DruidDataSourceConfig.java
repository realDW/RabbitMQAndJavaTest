package com.daiwei.rabbit.config.database;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/19 23:46
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Autowired
    private JDBCProperties jdbcProperties;

    @Autowired
    private DruidProperties druidProperties;

    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(druidProperties.getMaxActive());
        dataSource.setMinIdle(druidProperties.getMinIdle());
        dataSource.setMaxWait(druidProperties.getMaxWait());
        dataSource.setInitialSize(druidProperties.getInitialSize());
        dataSource.setUseGlobalDataSourceStat(druidProperties.isUseGlobalDataSourceStat());
        dataSource.setTestOnBorrow(druidProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(druidProperties.isTestOnReturn());
        dataSource.setValidationQuery(druidProperties.getValidationQuery());
        dataSource.setTestWhileIdle(druidProperties.isTestWhileIdle());
        dataSource.setPoolPreparedStatements(druidProperties.isPollPerparedStatements());
        dataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMills());

        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUrl(jdbcProperties.getUrl());

        logger.info("Druid DataSource initialized");
        return dataSource;
    }

    //配置事务
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());

    }
}
