package com.rj.stu.stuManagement.service;

import com.rj.stu.stuManagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StuInterface {
//    查询
    List<Student> QuertAll();
//    按照学号来查询学生信息
    Student selectByPrimaryKey(Integer sno);
//    新增
    boolean Add(Student student);
//    删除
    boolean Del(int sno);
//    修改
    boolean Update(Student student);
}
