package com.xns.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname PublishController
 * @Description TODO
 * @Date 19-8-7 下午9:43
 * @Created by xns
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("/title") String title,
            @RequestParam("description") String description,
            @RequestParam("tags") String tags
    ){
        return "publish";
    }
}
