package com.charlie.springcloud;

import com.charlie.springcloud.dao.MemberDao;
import com.charlie.springcloud.entity.Member;
import com.charlie.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class MemberApplication10010Test {

    @Resource
    private MemberDao memberDao;

    @Resource
    private MemberService memberService;

    /**
     * 注意引用注解时，使用的是
     * org.junit.jupiter.api中的@Test
     * 而非 org.junit 的@Test，否则 memberDap为空
     */
    @Test
    public void queryMemberById() {
        //Member member = memberDao.queryMemberById(1L);
        Member member = memberService.queryMemberById(3L);
        log.info("member={}", member);
    }

    @Test
    public void save() {
        Member member = new Member(null, "bill", "124", "163548487", "bill@google.com", 1);
        //int affected = memberDao.save(member);
        int affected = memberService.save(member);
        log.info("affected={}", affected);
    }

}
