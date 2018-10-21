package com.daiwei.rabbit.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/19 23:30
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config/druid.properties")
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {

    private int initialSize;

    private int minIdle;

    private int maxActive;

    private int maxWait;

    private long timeBetweenEvictionRunsMills;

    private long minEvictableIdleTimeMillis;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean pollPerparedStatements;

    private int maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    private boolean useGlobalDataSourceStat;

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public long getTimeBetweenEvictionRunsMills() {
        return timeBetweenEvictionRunsMills;
    }

    public void setTimeBetweenEvictionRunsMills(long timeBetweenEvictionRunsMills) {
        this.timeBetweenEvictionRunsMills = timeBetweenEvictionRunsMills;
    }

    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean isPollPerparedStatements() {
        return pollPerparedStatements;
    }

    public void setPollPerparedStatements(boolean pollPerparedStatements) {
        this.pollPerparedStatements = pollPerparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public boolean isUseGlobalDataSourceStat() {
        return useGlobalDataSourceStat;
    }

    public void setUseGlobalDataSourceStat(boolean useGlobalDataSourceStat) {
        this.useGlobalDataSourceStat = useGlobalDataSourceStat;
    }

    @Override
    public String toString() {
        return "DruidProperties{" +
                "initialSize=" + initialSize +
                ", minIdle=" + minIdle +
                ", maxActive=" + maxActive +
                ", maxWait=" + maxWait +
                ", timeBetweenEvictionRunsMills=" + timeBetweenEvictionRunsMills +
                ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis +
                ", validationQuery='" + validationQuery + '\'' +
                ", testWhileIdle=" + testWhileIdle +
                ", testOnBorrow=" + testOnBorrow +
                ", testOnReturn=" + testOnReturn +
                ", pollPerparedStatements=" + pollPerparedStatements +
                ", maxPoolPreparedStatementPerConnectionSize=" + maxPoolPreparedStatementPerConnectionSize +
                ", filters='" + filters + '\'' +
                ", useGlobalDataSourceStat=" + useGlobalDataSourceStat +
                '}';
    }
}
