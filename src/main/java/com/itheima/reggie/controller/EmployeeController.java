package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;


    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        // 1. 将页面提交的密码 password 进行 md5 加密处理
        String password = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes(StandardCharsets.UTF_8));

        // 2. 根据用户名查询用户
        Employee emp = employeeService.getOne(Wrappers.lambdaQuery(Employee.class).eq(Employee::getUsername, employee.getUsername()));

        if (emp == null) {
            return R.error("登录失败：用户名不存在");
        }

        if (!emp.getPassword().equals(password)) {
            return R.error("登录失败：密码错误");
        }

        if (emp.getStatus() == 0) {
            return R.error("账号已经禁用");
        }

        // 登录成功
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }
}
