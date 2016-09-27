package com.qianxuefeng.spring.api;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;  
  
@RestController  
@EnableAutoConfiguration  
@RequestMapping("/api/hello")  
public class HelloApi {  
      
    @RequestMapping(value = "", method = RequestMethod.GET)  
    String home() {  
        return "Hello Api!";  
    }  
      
    @RequestMapping(value = "/{myName}", method = RequestMethod.GET) 
    @ApiOperation(value = "hello who", notes = "输出 Hello${myName} </br>myName必填", code = 200, produces = "application/json")
    String index(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    }  
    
    @ApiIgnore //使用这个注解忽略这个接口，不在springfox文档列表中显示
    @RequestMapping(value = "/ignore", method = RequestMethod.GET)  
    String helloIgnore() {  
        return "Hello ignore!";  
    } 
}  