package com.xns.soringboot.entity;

/**
 * @Classname User
 * @Description TODO
 * @Date 19-8-1 下午7:28
 * @Created by xns
 */

/**
 * 配置映射关系
 * 使用JPA注解配置映射关系
 */
public class User {

    private Integer id;
    private String lastName;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
