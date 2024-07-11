package com.charlie.springcloud.controller;

import com.charlie.springcloud.entity.Member;
import com.charlie.springcloud.entity.Result;
import com.charlie.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class MemberController {

    // 装配MemberService
    @Resource
    private MemberService memberService;

    /**
     * 添加方法/接口
     * 1. 如果前端是以json格式发送数据，那么需要使用参数注解 @RequestBody 才能将数据封装到对应的bean，
     *      同时保证http的请求头的 content-type 是对应的 application/json
     * 2. 如果前端是以 表单 形式提交的，则不需要注解 @RequestBody 才能封装，
     *      对应的 content-type 为 application/x-www-form-urlencoded
     * 3. 注意：restTemplate.postForObject方法底层是将 对象(member) 以 json格式 发出的请求，
     *      因此，服务提供方(service-provider)的方法/接口，参数需要使用 @RequestBody 注解！
     */
    @PostMapping("/member/save")
    public Result save(@RequestBody Member member) {
        log.info("service-provider member={}", member);
        int affected = memberService.save(member);
        if (affected > 0) {
            return Result.success("添加会员成功", affected);
        }
        return Result.error("401", "添加会员失败");
    }

    /**
     * 查询的方法/接口
     */
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable(name = "id") Long id, HttpServletRequest req) {

        //String color = req.getParameter("color");
        //// 模拟休眠5s
        //try {
        //    TimeUnit.SECONDS.sleep(5);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}

        Member member = memberService.queryMemberById(id);
        if (member != null) {
            return Result.success("查询会员成功 member-service-provider-10010 " /*+ color*/, member);
        }
        return Result.error("402", "ID=" + id + "的会员不存在");
    }

}
