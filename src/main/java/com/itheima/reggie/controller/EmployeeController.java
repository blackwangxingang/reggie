package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;


    /**
     * 登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
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

        // 登录成功，将员工 id 存入 Session 并返回登录成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }


    /**
     * 退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        // 清理 Session 中保存的当前员工登录的 id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }
}
