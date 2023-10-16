package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王新刚
 * @date 2023/10/13 18:12
 */
@Mapper
public interface ClassroomMapper extends BaseMapper<Classroom>{
}
