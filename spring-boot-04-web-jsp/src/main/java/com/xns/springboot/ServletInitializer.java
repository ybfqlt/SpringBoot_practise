package com.xns.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    //重写configure,用configure来告诉一下SpringBoot的主程序在哪,这样应用一启动就知道主程序在哪,然后再来启动主程序
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBoot04WebJspApplication.class);
    }

}
