/*
* Copyright (c) 2016 qianxuefeng.com. All Rights Reserved.
*/
package com.qianxuefeng.spring.dao;

import com.qianxuefeng.spring.domain.TestUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qianxuefeng
 * @since 2016年9月28日
 */
@Mapper
public interface TestUserMapper {
    // 新增用户
    public int insert(TestUser testUser);

    // 用户列表
    public List<TestUser> list();

    // 登录
    public TestUser findByAccount(String account);
}