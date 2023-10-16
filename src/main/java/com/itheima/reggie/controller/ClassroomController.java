package com.itheima.reggie.controller;

import com.itheima.reggie.entity.Classroom;
import com.itheima.reggie.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王新刚
 * @date 2023/10/13 18:09
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService service;

    /**
     * 查询所有教室
     */
    @RequestMapping("/list")
    public List<Classroom> findAll() {
        return service.list();
    }

    /**
     * 新增教室
     */
    @RequestMapping("/save")
    public void save(@RequestBody Classroom classroom) {
        service.save(classroom);
    }


}
