package com.xns.springboot.mapper;

import com.xns.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Classname DepartmentMapper
 * @Description TODO
 * @Date 19-8-1 下午3:56
 * @Created by xns
 */

/**
 * 指定这是一个操作数据库的mapper
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);


    /**
     * 使用自动生成的主键,告诉人家哪个属性是封装主键的
     */
    @Options(useGeneratedKeys = true,keyProperty="id")
    @Insert("insert into department(department_name) values (#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id = #{id} ")
    public int updateDept(Department department);
}
