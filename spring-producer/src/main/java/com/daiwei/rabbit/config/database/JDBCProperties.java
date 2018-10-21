package com.daiwei.rabbit.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/19 23:47
 */
@Configuration
@ConfigurationProperties("spring.datasource")
public class JDBCProperties {

    private String username;

    private String password;

    private String url;

    private String driverClassName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "JDBCProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
