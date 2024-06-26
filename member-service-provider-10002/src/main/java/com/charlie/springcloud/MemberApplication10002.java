package com.charlie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  1. @EnableEurekaClient 将该程序标识为eureka-client
 */
@EnableEurekaClient
@SpringBootApplication
public class MemberApplication10002 {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication10002.class, args);
    }
}
