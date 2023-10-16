package com.itheima.reggie.entity;

import lombok.Data;

/**
 * @author 王新刚
 * @date 2023/10/13 17:29
 */
@Data
public class Department {
    /**
     * 部门ID
     */
    private Long id;

    /**
     * 部门名称
     */
    private String deptName;
}
