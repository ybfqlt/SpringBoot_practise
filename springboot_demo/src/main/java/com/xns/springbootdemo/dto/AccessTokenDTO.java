package com.xns.springbootdemo.dto;

import lombok.Data;

/**
 * @Classname AccessTokenDTO
 * @Description TODO
 * @Date 19-8-6 下午5:18
 * @Created by xns
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
