package com.charlie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 启用OpenFeignClient
public class MemberConsumerOpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerOpenfeignApplication.class, args);
    }
}
