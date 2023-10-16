package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.dto.StudentDto;
import com.itheima.reggie.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 王新刚
 * @date 2023/10/13 18:36
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<StudentDto> query();

}
