package com.xns.springboot.controller;

import com.xns.springboot.dao.EmployeeDao;
import com.xns.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        /**
         * thymeleaf默认就会拼串
         * public static final String DEFAULT_PREFIX = "classpath:/templates/";
         * public static final String DEFAULT_SUFFIX = ".html";
         * classpath:/templates/xxxx.html
         */
        return "emp/list";
    }
}
