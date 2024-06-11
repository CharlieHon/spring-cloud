package com.charlie.springcloud.controller;

import com.charlie.springcloud.entity.Member;
import com.charlie.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class MemberConsumerController {

    // 定义 member_service_provider 这是一个基础url地址
    public static final String MEMBER_SERVICE_PROVIDER = "http://localhost:10010";

    // 装配RestTemplate
    @Resource
    private RestTemplate restTemplate;

    // 方法/接口，添加member对象到数据库
    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member) {
        log.info("service-consumer member={}", member);
        /**
         * 请求的完整url：MEMBER_SERVICE_PROVIDER + "/member/save" -> http://localhost:10010/member/save
         * member：通过restTemplate发出的post请求，携带的数据/对象
         * Result.class：返回结果的类型<br/>
         * 注意：restTemplate.postForObject方法底层是将 对象(member) 以 json格式 发出的请求，
         *  因此，服务提供方(service-provider)的方法/接口，参数需要使用 @RequestBody 注解！
         */
        return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER + "/member/save", member, Result.class);
    }

    // 方法/接口，根据id调用服务接口，返回member对象信息
    @GetMapping("/member/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable(name = "id") Long idx) {
        return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER + "/member/get/" + idx, Result.class);
    }

}
