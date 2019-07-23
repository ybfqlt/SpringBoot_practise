package com.xns.springbootfast.bean;


import org.springframework.context.annotation.Bean;

/**
 * @Classname Dog
 * @Description TODO
 * @Date 19-7-23 上午8:48
 * @Created by xns
 */
public class Dog {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Bean
    public void dog(){
        
    }
}
