package com.qianxuefeng.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	
	public PageInfo<TestUser> list(Integer page, Integer pageSize) {
		if(page!= null && pageSize!= null){  
            PageHelper.startPage(page, pageSize);  
        }
        List<TestUser> users = userMapper.list();  
        return new PageInfo<TestUser>(users);  
	}
}
