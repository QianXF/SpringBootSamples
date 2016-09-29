package com.qianxuefeng.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianxuefeng.spring.dao.TestUserMapper;
import com.qianxuefeng.spring.domain.TestUser;

/**
 * 
 * @author qianxuefeng
 * @date 2016年9月27日
 * @copyright: copyright @ HeleTech 2016
 */
@Service
public class HelloService {

	@Autowired
	private TestUserMapper userMapper;
	
	public String hello(String str){
		return str;
	}
	
	public List<TestUser> list() {
		return userMapper.list();
	}
}
