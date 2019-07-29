package com.xns.springboot.controller;

import com.xns.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MyExceptionHandler
 * @Description TODO
 * @Date 19-7-27 上午11:58
 * @Created by xns
 */

//异常指示器
@ControllerAdvice
public class MyExceptionHandler {

    //浏览器客户端返回的都是json数据
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/


    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx,5xx等
        /***
        * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        *
        **/
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        //转发到/error让BasicErrorController进行自适应页面
        return "forward:/error";
    }
}
