package com.xns.springbootdemo.controller;

import com.xns.springbootdemo.dto.AccessTokenDTO;
import com.xns.springbootdemo.dto.GithubUser;
import com.xns.springbootdemo.mapper.UserMapper;
import com.xns.springbootdemo.model.User;
import com.xns.springbootdemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


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

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state, HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGntModified(user.getGmtCreate());
            userMapper.insert(user);
            /**
             * 登录成功，写cookie和session
             */
            request.getSession().setAttribute("user",githubUser);
            /**
             * 去掉先前的地址，重定向到index的页面
             */
            return "redirect:/";
        }
        else{
            /**
             * 登录失败，重新登录
             */
            return "redirect:/";
        }
    }
}
