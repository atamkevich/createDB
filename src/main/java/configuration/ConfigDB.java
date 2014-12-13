package configuration;

import configuration.annotations.DealersDB;
import configuration.annotations.SentinelDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Alina_Tamkevich
 */
@Configuration
@ComponentScan({"configuration", "impl"})
public class ConfigDB {

    @Bean
    @DealersDB
    JdbcTemplate jdbcTemplateDBWSP(@DealersDB DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }



    @Bean
    @SentinelDB
    JdbcTemplate jdbcTemplateSentinel(@SentinelDB DataSource jdbcDataSource) {
        return new JdbcTemplate(jdbcDataSource);
    }


    @Bean
    @SentinelDB
    DataSource sentinelDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?search_path=sentinel");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }


    @Bean
    @DealersDB
    DataSource jdbcDataSourceDBWSP() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://dbwsp.vip.edmunds.com:5444/DBWSP");
        dataSource.setUsername("sentinel_apps");
        dataSource.setPassword("=08i087uoyr");
        return dataSource;
    }
}
