package com.xns.springbootdemo.provider;

import com.alibaba.fastjson.JSON;
import com.xns.springbootdemo.dto.AccessTokenDTO;
import com.xns.springbootdemo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * @Classname GithubProvider
 * @Description TODO
 * @Date 19-8-6 下午5:16
 * @Created by xns
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        /**
         * 请求access_token携带coed
         */
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
                /**
                * 返回access_token=e9bfbe80c10236193c44f622d54e91b498bc7362&scope=user&token_type=bearer
                */
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
            /**
             * 返回获取到的access_token
             */
            return token;
            } catch (Exception e) {
                 e.printStackTrace();
            }
        return null;
    }


    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        /**
         * 请求https://api.github.com/user携带access_token
         */
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            /**
             * 返回用户信息
             */
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}
