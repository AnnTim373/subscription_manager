package org.timofeeva.subman.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "org.timofeeva.subman.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties submanDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public HikariDataSource submanDataSource() {
        return submanDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
