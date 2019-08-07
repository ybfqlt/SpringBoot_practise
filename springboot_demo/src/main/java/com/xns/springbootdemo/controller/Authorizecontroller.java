package com.xns.springbootdemo.controller;

import com.xns.springbootdemo.dto.AccessTokenDTO;
import com.xns.springbootdemo.dto.GithubUser;
import com.xns.springbootdemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Classname Authorizecontroller
 * @Description TODO
 * @Date 19-8-6 下午5:06
 * @Created by xns
 */
@Controller
public class Authorizecontroller {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("db6224604a048ce4795c");
        accessTokenDTO.setClient_secret("cd7586b23f6becba5341bee0d39087ad2e570b12");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8087/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
