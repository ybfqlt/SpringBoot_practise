package com.xns.springbootdemo.model;

import lombok.Data;

/**
 * @Classname User
 * @Description TODO
 * @Date 19-8-7 下午3:06
 * @Created by xns
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
