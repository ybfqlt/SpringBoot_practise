package com.xns.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @Classname MybatisConfig
 * @Description TODO
 * @Date 19-8-1 下午4:32
 * @Created by xns
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration){
                /**
                 * 开启驼峰命名法映射规则
                 */
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
