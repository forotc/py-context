package com.ailu.pycontext.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2018/4/28 9:59
 */
@Configuration
public class PageHelperConfig {

    public static final String helperDialect = "mysql";

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", helperDialect);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

}
