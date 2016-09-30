package com.qianxuefeng.spring.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author qianxuefeng
 * @date 2016年9月30日
 * @copyright: copyright @ HeleTech 2016
 */
@Controller
@RequestMapping("/fm")  
public class FreeMarkerController {

    @RequestMapping("/web")  
    public String web(ModelMap model){  
        model.put("time",new Date());  
        model.put("message","欢迎使用freemarker。");  
        model.put("detail",null);  
        return "web";//返回的内容就是templetes下面文件的名称  
    }  
}
