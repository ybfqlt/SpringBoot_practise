package com.xns.springbootfast.config;

import com.xns.springbootfast.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyAppConfig
 * @Description TODO
 * @Date 19-7-23 上午11:11
 * @Created by xns
 */

/**
 * 指明当前类是一个配置类;就是来提到之前的Spring配置文件
 *
 * 使用@Bean注解添加组件
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("配置类给@Bena给容器中添加组件了!");
        return new HelloService();
    }
}
