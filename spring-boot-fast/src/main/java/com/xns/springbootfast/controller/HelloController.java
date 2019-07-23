package com.xns.springbootfast.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 19-7-22 下午8:52
 * @Created by xns
 */
@RestController
public class HelloController {

    @Value("${person.lastName}")
    private String name;

    @RequestMapping("/hello")
    public String sayhello(){
        return "hello "+name;
    }
}
