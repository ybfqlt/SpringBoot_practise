package com.xns.springbootdemo.dto;

import com.xns.springbootdemo.model.User;
import lombok.Data;

/**
 * @Classname QuestionDTO
 * @Description TODO
 * @Date 19-8-8 下午5:05
 * @Created by xns
 */
@Data
public class QuestionDTO {

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
    private User user;
}
