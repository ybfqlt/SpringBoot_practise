package com.xns.springboot.controller;

import com.xns.springboot.dao.DepartmentDao;
import com.xns.springboot.dao.EmployeeDao;
import com.xns.springboot.entities.Department;
import com.xns.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Classname EmployeeController
 * @Description TODO
 * @Date 19-7-26 上午10:47
 * @Created by xns
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        /**
         * thymeleaf默认就会拼串
         * public static final String DEFAULT_PREFIX = "classpath:/templates/";
         * public static final String DEFAULT_SUFFIX = ".html";
         * classpath:/templates/xxxx.html
         */
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门,在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参属性进行一一绑定,要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息: "+employee);
        //保存员工
        employeeDao.save(employee);
        //redirect: 重定向到一个地址   /代表当前项目路径
        //forward:转发到一个地址
        //以上两种方法不会经过模版引擎解析拼接
        return "redirect:/emps";
    }
}
