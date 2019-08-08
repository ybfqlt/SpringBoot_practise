package com.xns.springbootdemo.model;

import lombok.Data;

/**
 * @Classname Question
 * @Description TODO
 * @Date 19-8-8 上午11:03
 * @Created by xns
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
