package com.charlie.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope SpringCloud原生注解，实现了配置数据的自动刷新
 */
@RestController
@Slf4j
@RefreshScope
public class NacosConfigClientController {

    /**
     * 1. client会拉取nacos server的 e-commerce-nacos-config-client-dev.yaml
     * config:
     *      ip: "122.22.22.22"
     *      name: "快乐修勾"
     * 2. @Value("${config.ip}") 会将 config.ip 赋值给 configIp;
     * 3. 注解中的值，要根据配置来写
     */
    @Value("${config.ip}")
    private String configIp;

    @Value("${config.name}")
    private String configName;

    @GetMapping("/nacos/config/ip")
    public String getConfigIp() {
        return configIp;
    }

    @GetMapping("/nacos/config/name")
    public String getConfigName() {
        return configName;
    }

}
