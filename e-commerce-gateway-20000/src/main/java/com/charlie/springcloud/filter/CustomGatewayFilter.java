package com.charlie.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomGatewayFilter implements GlobalFilter, Ordered {

    /**
     * filter是核心方法，将过滤业务写在该方法中
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("CustomGatewayFilter 执行...");
        // 选获取到对应的参数值
        // 比如 http://localhost:20000/member/get/1?user=hsp&pwd=123
        // exchange.getRequest().getQueryParams().get("user").get(0);   // get("user")返回的是一个列表
        String user = exchange.getRequest().getQueryParams().getFirst("user");
        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
        if (!("hsp".equals(user) && "123456".equals(pwd))) {    // 如果不满足条件
            log.info("非法用户！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);    // 回应406
            return exchange.getResponse().setComplete();
        }

        log.info("验证通过...");
        return chain.filter(exchange);
    }

    /**
     * order 表示过滤器执行的顺序，数字越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
