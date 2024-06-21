package com.charlie.springcloud.service;

import com.charlie.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 该接口由openfeign实现
@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {
    // 定义方法，远程调用的接口

    /**
     * 1. 远程调用方式是get
     * 2. 远程调用的url http://MEMBER-SERVICE-PROVIDER(ip:port)/member/get/{id}
     * 3. MEMBER-SERVICE-PROVIDER 就是服务提供方在eureka-server注册的服务名称
     * 4. open-feign会根据负载均衡来决定调用10010/10002，默认轮询算法
     * 5. 因为openfeign好处是支持springmvc注解+接口解耦
     * 6. 接口方法上 value = "/member/get/{id}" 不能乱写，要与远程调用的value值保持一致
     */
    @GetMapping(value = "/member/get/{id}")
    Result getMemberById(@PathVariable(name = "id") Long id);
}
