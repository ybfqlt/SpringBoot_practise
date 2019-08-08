package com.xns.springbootdemo.mapper;

import com.xns.springbootdemo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname QuestionMapper
 * @Description TODO
 * @Date 19-8-8 上午10:56
 * @Created by xns
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
