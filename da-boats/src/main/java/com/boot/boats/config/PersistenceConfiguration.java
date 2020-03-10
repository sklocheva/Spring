package com.boot.boats.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Sophia Klocheva
 * on 2/18/2020
 */
@Configuration
public class PersistenceConfiguration
{
    // the return must be stored and returned as a spring bean
    @Bean
    // use connection from application.properties
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.flyway")
    @FlywayDataSource
    public DataSource flywayDataSource()
    {
        return DataSourceBuilder.create().build();
    }
}
