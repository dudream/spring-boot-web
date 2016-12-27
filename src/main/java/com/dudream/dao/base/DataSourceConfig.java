package com.dudream.dao.base;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource multiDataSource() throws Exception {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource defaultDataSource = null;
        for (DataSourceType dataSourceType : DataSourceType.values()) {
            Properties props = this.getPropsByDataSourceName(dataSourceType.getValue());
            DataSource dataSource = BasicDataSourceFactory.createDataSource(props);
            targetDataSources.put(dataSourceType.getValue(), dataSource);

            if (dataSourceType.isDefault()) {
                defaultDataSource = dataSource;
            }
        }

        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setTargetDataSources(targetDataSources);
        multipleDataSource.setDefaultTargetDataSource(defaultDataSource);

        return multipleDataSource;
    }

    private Properties getPropsByDataSourceName(String dataSourceName) {
        Properties userProps = new Properties();
        String prefix = "jdbc.";
        userProps.put("driverClassName", env.getProperty(prefix + dataSourceName + ".driver-class-name"));
        userProps.put("url", env.getProperty(prefix + dataSourceName + ".url"));
        userProps.put("username", env.getProperty(prefix + dataSourceName + ".username"));
        userProps.put("password", env.getProperty(prefix + dataSourceName + ".password"));
        userProps.put("maxActive", env.getProperty(prefix + dataSourceName + ".maxActive"));
        userProps.put("initialSize", env.getProperty(prefix + dataSourceName + ".initialSize"));
        userProps.put("maxWait", env.getProperty(prefix + dataSourceName + ".maxWait"));
        userProps.put("minIdle", env.getProperty(prefix + dataSourceName + ".minIdle"));
        userProps.put("timeBetweenEvictionRunsMillis", env.getProperty(prefix + dataSourceName + ".timeBetweenEvictionRunsMillis"));
        userProps.put("minEvictableIdleTimeMillis", env.getProperty(prefix + dataSourceName + ".minEvictableIdleTimeMillis"));

        return userProps;
    }

}
