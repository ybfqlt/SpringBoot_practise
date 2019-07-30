package com.xns.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 19-7-30 下午4:06
 * @Created by xns
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }
}
