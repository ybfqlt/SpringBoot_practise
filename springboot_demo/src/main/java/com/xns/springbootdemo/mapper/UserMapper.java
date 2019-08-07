package com.xns.springbootdemo.mapper;

import com.xns.springbootdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 19-8-7 下午3:04
 * @Created by xns
 */
@Mapper
public interface UserMapper {

    /**
     * 自动调用User的get方法
     */
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
