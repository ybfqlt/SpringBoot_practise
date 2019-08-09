package com.xns.springbootdemo.mapper;

import com.xns.springbootdemo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname QuestionMapper
 * @Description TODO
 * @Date 19-8-8 上午10:56
 * @Created by xns
 */
@Mapper
public interface QuestionMapper {

    /**
     * 向问题表中插入数据
     * @param question
     */
    @Insert("insert into question (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    /**
     * 按限制返回查询到的问题
     * @param offset 偏移量
     * @param size 返回记录的数量
     * @return List<Question>
     */
    @Select("select * from question LIMIT #{size} OFFSET #{offset}")
    List<Question> list(@Param(value="offset") Integer offset, @Param(value="size") Integer size);

    /**
     *
     * @return 问题表中的记录总数
     */
    @Select("select count(1) from QUESTION")
    Integer count();
}
