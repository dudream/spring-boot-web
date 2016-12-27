package com.dudream.bean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dudream on 2016/12/27.
 */
@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class Config {

    private String env;

}
