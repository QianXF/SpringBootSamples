/*
* Copyright (c) 2016 qianxuefeng.com. All Rights Reserved.
*/
package com.qianxuefeng.spring.dao;

import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qianxuefeng.spring.domain.TestUser;

/**
 *
 * @author qianxuefeng
 * @date 2016年9月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapperTest {
    @Autowired
    private TestUserMapper userMapper;

    @Test
    public void test() {
        List<TestUser> users = userMapper.list();
        assertSame(users.size(), 2);
    }

}