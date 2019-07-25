package com.xns.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname MyMvcConfig
 * @Description TODO
 * @Date 19-7-25 上午9:08
 * @Created by xns
 */

@EnableWebMvc
//使用webMvcConfigurerAdapter可以来扩展SpringMVC功能
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /xns 请求也来到 success 页面
        registry.addViewController("/xns").setViewName("success");
    }
}
