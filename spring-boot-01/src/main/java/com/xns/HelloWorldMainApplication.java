package com.xns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname HelloWorldMainApplication
 * @Description TODO
 * @Date 19-7-22 下午4:43
 * @Created by xns
 */
@SpringBootApplication //Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类
public class HelloWorldMainApplication {
    public static void main(String[] args) {

        //Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
