package com.qianxuefeng.spring.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianxuefeng.spring.constants.ErrorCodeConstants;
import com.qianxuefeng.spring.domain.ApiResult;  
  
@Controller  
@RequestMapping
public class ErrorController {  
      
	// 页面访问，返回404页面
    @RequestMapping(value="/404", method=RequestMethod.GET, produces="text/html")  
    String _404() {  
        return "error/404";  
    }
    
    // json访问，返回json格式报错
    @RequestMapping(value="/404", method=RequestMethod.GET)  
    @ResponseBody  
    ApiResult _404Json() {
        return new ApiResult().addErrorCode(ErrorCodeConstants.URL_ERROR);  
    }
    
    @RequestMapping(value="/500", method=RequestMethod.GET, produces="text/html")  
    String _500() {  
        return "error/500";  
    } 
    
    // json访问，返回json格式报错
    @RequestMapping(value="/500", method=RequestMethod.GET)  
    @ResponseBody  
    ApiResult _500Json() {
        return new ApiResult().addErrorCode(ErrorCodeConstants.SERVER_ERROR);  
    }
      
}  