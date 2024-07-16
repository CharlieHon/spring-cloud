//package com.charlie.springcloud.config;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * RibbonRule：配置类。配置注入自定义负载均衡算法
// */
//@Configuration
//public class RibbonRule {
//
//    @Bean
//    public IRule myRibbonRule() {
//        // 返回 RandomRule
//        return new RandomRule();
//    }
//
//}
