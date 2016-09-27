package com.qianxuefeng.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.qianxuefeng.spring.controller.HelloController; 

/**
 * 
 * @author qianxuefeng
 * @date 2016年9月27日
 * @copyright: copyright @ HeleTech 2016
 */
@SpringBootTest
public class HelloControllerTest {
	private MockMvc mvc;
	
	@Before  
    public void setUp() {  
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();  
    }  
	
	@Test  
    public void getHello() throws Exception {  
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON));  
        actions.andExpect(status().isOk());  
    }  

}
