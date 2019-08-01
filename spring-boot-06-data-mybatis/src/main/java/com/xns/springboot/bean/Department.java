package com.xns.springboot.bean;

/**
 * @Classname Department
 * @Description TODO
 * @Date 19-8-1 下午3:41
 * @Created by xns
 */
public class Department {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
