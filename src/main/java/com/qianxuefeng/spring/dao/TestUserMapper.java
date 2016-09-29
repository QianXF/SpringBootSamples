/*
* Copyright (c) 2016 qianxuefeng.com. All Rights Reserved.
*/
package com.qianxuefeng.spring.dao;

import com.qianxuefeng.spring.domain.TestUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qianxuefeng  Date: 16/9/28 下午12:22
 */
@Mapper
public interface TestUserMapper {
    public int insert(TestUser testUser);

    public List<TestUser> list();
}