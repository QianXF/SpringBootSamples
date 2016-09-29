package com.qianxuefeng.spring.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.qianxuefeng.spring.domain.TestUser;

/**
 * 
 * @author qianxuefeng
 * @date 2016年9月27日
 * @copyright: copyright @ HeleTech 2016
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class HelloServiceTest {
	@Autowired
	private HelloService helloService;

	@Test
	public void hello() {
		String hello = helloService.hello("你好");
		assertEquals(hello, "你好");
	}
	
	@Test
	public void list() {
		PageInfo<TestUser> users = helloService.list(1, 2);
		assertEquals(users.getPageNum(), 1);
	}

}
