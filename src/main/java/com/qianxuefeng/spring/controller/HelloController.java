package com.qianxuefeng.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qianxuefeng.spring.domain.TestUser;
import com.qianxuefeng.spring.service.HelloService;  
  
@RestController  
@EnableAutoConfiguration  
@RequestMapping("/hello")  
public class HelloController {  
      
	@Autowired
	private HelloService helloService;
	
    @RequestMapping(value="", method=RequestMethod.GET)  
    String home() {  
        return "Hello World!";  
    }  
      
    @RequestMapping(value="/{myName}", method=RequestMethod.GET)
    String index(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    }  
    
    @RequestMapping(value="/users", method=RequestMethod.GET)
    List<TestUser> users(){
    	return helloService.list();
    }
    
}  