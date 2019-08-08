package com.xns.springbootdemo.dto;

import lombok.Data;

/**
 * @Classname GithubUser
 * @Description TODO
 * @Date 19-8-6 下午8:06
 * @Created by xns
 */
@Data
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatar_Url;
}
