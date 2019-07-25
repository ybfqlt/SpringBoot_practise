package com.xns.springboot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 19-7-25 下午4:12
 * @Created by xns
 */
@Controller
public class LoginController {

    //@RequestMapping(value="/user/login",method = RequestMethod.POST)
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登陆成功,方式表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else{
            //登录失败
            map.put("msg","用户名密码错误!!!");
            return "login";
        }
    }
}
