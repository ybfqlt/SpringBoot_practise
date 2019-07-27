package com.xns.springboot.exception;

/**
 * @Classname UserNotExistException
 * @Description TODO
 * @Date 19-7-27 上午11:49
 * @Created by xns
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在!!!");
    }
}
