package com.rj.stu.stuManagement.service;

import com.rj.stu.stuManagement.entity.Student;
import com.rj.stu.stuManagement.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StuImpl implements StuInterface{
    @Autowired
    private StudentMapper studentMapper;
//    查询
    public List<Student> QuertAll() {
        List<Student> students = studentMapper.QueryAll();
        return students;
    }

    //    按照学号来查询学生信息
    public Student selectByPrimaryKey(Integer sno) {
        Student student = studentMapper.selectByPrimaryKey(sno);
        return student;
    }

    //新增
    public boolean Add(Student student) {
        int i = studentMapper.insert(student);
        if(i>0)
            return true;
        else
          return false;
    }
//删除
    public boolean Del(int sno) {
        int i = studentMapper.deleteByPrimaryKey(sno);
        if(i>0)
            return true;
        else
            return false;
    }
// 更新
    public boolean Update(Student student) {
        int i = studentMapper.updateByPrimaryKey(student);
        if(i>0)
            return true;
        else
            return false;
    }
}
