//package com.charlie.springcloud.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GateWayRoutesConfig {
//
//    /**
//     * 配置注入路由
//     * 在理解通过配置类注入/配置路由，可以对照前面的application.yaml
//     *   cloud:
//     *     gateway:
//     *       routes: # 配置路由，可以配置多个路由 List<RouteDefinition> routes
//     *         - id: member_route01  # 路由id，自定义配置，要求唯一
//     *           # gateway最终访问的url=uri+Path
//     *           # 匹配后提供服务的路由地址也可以是外网如 http://baidu.com
//     *           # 比如：客户端/浏览器请求url：http://localhost:20000/member/get/1，其中localhost:20000用于找到网关服务
//     *           # 如果根据Path匹配成功，最终访问的url/转发url就是 url=http://localhost:10010/member/get/1
//     *           # 如果匹配失败，则由gateway返回404信息
//     *           # 这里配置固定的uri，在当前这种情况可以不使用eureka-server
//     *           uri: http://localhost:10010
//     *           predicates: # 断言可以有多种形式
//     *             - Path=/member/get/**
//     */
//    @Bean
//    public RouteLocator myRouteLocator04(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        // 1. 下面的方法分别指定了id，uri，Path
//        // 2. Function<PredicateSpec, Route.AsyncBuilder> fn
//        //  1> 是一个函数式接口
//        //  2> 接收的类型是 PredicateSpec，返回的类型是Route.AsyncBuilder
//        //  3> r -> r.path("/member/get/**").uri("http://localhost:10010") 是一个lambda表达式
//        return routes.route("member_route04", r -> r.path("/member/get/**").uri("http://localhost:10010")).build();
//    }
//
//    @Bean
//    public RouteLocator myRouteLocator05(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        return routes.route("member_route04", r -> r.path("/member/save").uri("http://localhost:10010")).build();
//    }
//}
