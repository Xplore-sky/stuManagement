package com.rj.stu.stuManagement.mapper;

import com.rj.stu.stuManagement.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface StudentMapper {
//   删除
    int deleteByPrimaryKey(Integer sno);
//  新增
    int insert(Student record);
//
    int insertSelective(Student record);
//按照学号查询
    Student selectByPrimaryKey(Integer sno);
//更新
    int updateByPrimaryKeySelective(Student record);
//
    int updateByPrimaryKey(Student record);

//    查询
    List<Student> QueryAll();
}