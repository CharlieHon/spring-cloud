package com.charlie.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * CustomizationBean: 配置类
 * 配置注入 RestTemplate bean/对象
 */
@Configuration
public class CustomizationBean {

    /**
     * 配置注入 RestTemplate bean/对象
     * 1. 注解 @LoadBalanced 赋予RestTemplate负载均衡能力，默认是使用轮询算法来访问远程调用接口/地址
     * 2. 底层是Ribbon支持算法，Ribbon和Eureka整合后consumer直接调用服务而不用再关心地址和端口号，
     *      且该服务还有负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
