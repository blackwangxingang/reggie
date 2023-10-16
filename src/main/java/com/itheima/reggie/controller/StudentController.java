package com.itheima.reggie.controller;

import com.itheima.reggie.dto.StudentDto;
import com.itheima.reggie.entity.Student;
import com.itheima.reggie.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王新刚
 * @date 2023/10/13 18:35
 */

@Slf4j
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    /**
     * 联合查询所有学生
     * @return
     */
    @GetMapping("/query")
    public List<StudentDto> query() {
        return service.queryList();
    }
}
