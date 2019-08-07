package com.xns.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 19-8-6 上午9:39
 * @Created by xns
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
