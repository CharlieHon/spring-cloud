package com.charlie.springcloud.service;

import com.charlie.springcloud.entity.Member;

public interface MemberService {
    // 根据id返回member
    Member queryMemberById(Long id);

    // 添加Member
    int save(Member member);
}
