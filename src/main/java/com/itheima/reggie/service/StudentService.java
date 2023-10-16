package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.dto.StudentDto;
import com.itheima.reggie.entity.Student;
import com.itheima.reggie.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王新刚
 * @date 2023/10/13 18:35
 */

@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {
    public List<StudentDto> queryList() {
        return this.getBaseMapper().query();
    }
}
