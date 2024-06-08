# SpringCloud & SpringCloud Alibaba(一套标准化的微服务解决方案)

## member-service-provider-10000

### mysql

```mysql
CREATE DATABASE IF NOT EXISTS e_commerce_center_db;
USE e_commerce_center_db;
CREATE TABLE `member` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR(64) COMMENT '用户名',
	`pwd` CHAR(32) COMMENT '密码',
	`mobile` VARCHAR(20) COMMENT '手机号码',
	`email` VARCHAR(64) COMMENT '邮箱',
	`gender` TINYINT COMMENT '性别',
	PRIMARY KEY (`id`)
);

INSERT INTO `member` VALUES 
	(NULL, 'charlie', MD5('123'), '123456789545', 'charlie@gmail.com', 1),
	(NULL, 'snow', MD5('456'), '123568975520', 'snow@163.com', 0);

SELECT * FROM `member`;
```

### Dao

- 注意在 `MemberDao.java` 上加入注解 `@Mapper`，才会注入bean
- [MemberDao](member-service-provider-10000/src/main/java/com/charlie/springcloud/dao/MemberDao.java)
- [MemberMapper.xml](member-service-provider-10000/src/main/resources/mapper/MemberDao.xml)

### Service

- 注意在 `MemberServiceImpl.java` 上加入注解 `@Service`
- 在注入装配时，使用 `@Service` 注解 `private MemberService memberService;`
- [MemberService](member-service-provider-10000/src/main/java/com/charlie/springcloud/service/MemberService.java)
- [MemberServiceImpl](member-service-provider-10000/src/main/java/com/charlie/springcloud/service/impl/MemberServiceImpl.java)

### Controller

```java
package com.charlie.springcloud.controller;

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
     */
    @PostMapping("/member/save")
    public Result save(Member member) {
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
    public Result getMemberById(@PathVariable(name = "id") Long id) {
        Member member = memberService.queryMemberById(id);
        if (member != null) {
            return Result.success("查询成功", member);
        }
        return Result.error("402", "ID=" + id + "的会员不存在");
    }
}
```

### 注意事项和细节

> 1. 在进行SpringBoot应用程序测试时，引入的JUnit是`org.junit.jupiter.api.Test`
> 2. 在运行程序时，一定要确保你的`XxxMapper.xml`文件被自动放到的`target`目录的`classes`指定目录
