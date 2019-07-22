package com.xns.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 19-7-22 下午4:56
 * @Created by xns
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
