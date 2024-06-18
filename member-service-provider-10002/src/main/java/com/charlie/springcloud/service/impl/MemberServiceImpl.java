package com.charlie.springcloud.service.impl;

import com.charlie.springcloud.dao.MemberDao;
import com.charlie.springcloud.entity.Member;
import com.charlie.springcloud.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    @Override
    public Member queryMemberById(Long id) {
        return memberDao.queryMemberById(id);
    }

    @Override
    public int save(Member member) {
        return memberDao.save(member);
    }
}
