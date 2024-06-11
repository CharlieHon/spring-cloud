package com.charlie.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * CustomizationBean: 配置类
 * 配置注入 RestTemplate bean/对象
 */
@Configuration
public class CustomizationBean {

    // 配置注入 RestTemplate bean/对象
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
