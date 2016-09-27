package com.qianxuefeng.spring.controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
@EnableAutoConfiguration  
public class HelloController {  
      
    @RequestMapping("/")  
    String home() {  
        return "Hello World!";  
    }  
      
    @RequestMapping("/hello/{myName}") 
    String index(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    }  
    
}  