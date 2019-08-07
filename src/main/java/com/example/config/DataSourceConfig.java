package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

/**
 * Created by huangyali on 2019/8/7.
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;

    /*@Bean
    public DataSource counterDatasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("first.datasource.url"));
        dataSource.setUsername(env.getProperty("first.datasource.username"));
        dataSource.setPassword(env.getProperty("first.datasource.password"));
        return dataSource;
    }*/
}
