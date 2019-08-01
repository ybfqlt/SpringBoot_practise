package com.xns.springboot.mapper;

/**
 * @Classname EmployeeeMapper
 * @Description TODO
 * @Date 19-8-1 下午4:58
 * @Created by xns
 */

import com.xns.springboot.bean.Employee;

/**
 * 使用@Mapper或者@MapperScan将接口扫描装配到容器中
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
