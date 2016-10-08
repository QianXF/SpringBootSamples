package com.qianxuefeng.spring.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  
  
@Controller  
@RequestMapping
public class ErrorController {  
      
    @RequestMapping(value="/404", method=RequestMethod.GET)  
    String _404() {  
        return "error/404";  
    }
    
    @RequestMapping(value="/500", method=RequestMethod.GET)  
    String _500() {  
        return "error/500";  
    }  
      
}  