package com.xns.springbootdemo.mapper;

import com.xns.springbootdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
