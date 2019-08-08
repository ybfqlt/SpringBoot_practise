package com.xns.springbootdemo.controller;

import com.xns.springbootdemo.dto.QuestionDTO;
import com.xns.springbootdemo.mapper.QuestionMapper;
import com.xns.springbootdemo.mapper.UserMapper;
import com.xns.springbootdemo.model.Question;
import com.xns.springbootdemo.model.User;
import com.xns.springbootdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 19-8-6 上午9:39
 * @Created by xns
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0 ) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
