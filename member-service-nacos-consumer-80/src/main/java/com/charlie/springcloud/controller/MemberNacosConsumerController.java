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

@RestController
@Slf4j
public class MemberNacosConsumerController {

    // "htt://?" 其中？为服务注册到Nacos server的服务名，这里是小写
    public static final String MEMBER_SERVICE_NACOS_PROVIDER_URL = "http://member-service-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    // 方法1：添加member
    @PostMapping("/member/nacos/consumer/save")
    public Result<Member> save(Member member) {
        return restTemplate.postForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/save", member, Result.class);
    }

    // 方法2：查询member
    @GetMapping("/member/nacos/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/get/" + id, Result.class);
    }
}
