package com.charlie.springcloud.dao;

import com.charlie.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    // 根据id返回member数据
    public Member queryMemberById(Long id);

    // 添加member
    public int save(Member member);

}
