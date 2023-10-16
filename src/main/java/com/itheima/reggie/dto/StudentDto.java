package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Student;
import lombok.Data;

/**
 * @author 王新刚
 * @date 2023/10/13 18:48
 */
@Data
public class StudentDto extends Student {
    private String className;
}
