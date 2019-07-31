package com.xns.springboot.config;

import com.xns.springboot.filter.MyFilter;
import com.xns.springboot.listener.MyListener;
import com.xns.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/**
 * @Classname MyServerConfig
 * @Description TODO
 * @Date 19-7-29 下午9:16
 * @Created by xns
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册三大组件
     * 第一个有问题,尚未解决
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet");
    }

    @Bean
    public FilterRegistrationBean  cvyFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }


    /**
     * 配置嵌入式的Servlet容器
     */
    @Bean    //把它加到容器中,这样SpringBoot才能知道它的存在
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){

            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory){
                factory.setPort(8083);
            }
        };
    }

}
