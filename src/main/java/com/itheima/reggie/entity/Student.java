package com.itheima.reggie.entity;

import lombok.Data;

/**
 * @author 王新刚
 * @date 2023/10/13 18:02
 */
@Data
public class Student {
    /**
     * 学生ID
     */
    private Long id;

    /**
     * 学号
     */
    private Long stdNo;

    /**
     * 姓名
     */
    private String stdName;

    /**
     * 年龄
     */
    private Integer stdAge;

    /**
     * 班级ID
     */
    private Long classId;

}
