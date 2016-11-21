package com.qianxuefeng.spring.web;

import com.qianxuefeng.spring.constants.ErrorCodeConstants;
import com.qianxuefeng.spring.domain.ApiResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller  
@RequestMapping
public class SessionController {
      
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, ModelMap model) {
        if ((request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)))
        {
            return "error/timeoutJson";
        }

        //先登出
        SecurityUtils.getSubject().logout();

        String errorClassName = (String) request
                .getAttribute("shiroLoginFailure");
        String authticationError = null;
        if (UnknownAccountException.class.getName().equals(errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(
                errorClassName)) {
            authticationError = "用户名/密码错误";
        } else if (errorClassName != null) {
            authticationError = "系统异常，请稍后再试";
        }

        model.put("errorMessage", authticationError);

        return "login";
    }

    @RequestMapping({ "/", "/index" })
    public String index(ModelMap model) {
        model.put("time",new Date());
        model.put("message","欢迎使用freemarker。");
        model.put("detail",null);
        return "web";//返回的内容就是templetes下面文件的名称
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        //登出
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/unauth")
    public String unauth() {
        return "error/unauth";
    }
}  