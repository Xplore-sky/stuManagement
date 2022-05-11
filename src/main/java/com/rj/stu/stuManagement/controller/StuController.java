package com.rj.stu.stuManagement.controller;

import com.rj.stu.stuManagement.entity.Student;
import com.rj.stu.stuManagement.service.StuImpl;
import com.rj.stu.stuManagement.service.StuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StuController {
    @Autowired
    private StuInterface stuInterface;
//    查询
    @RequestMapping("/Display")
    public ModelAndView Display(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = stuInterface.QuertAll();
        modelAndView.addObject("students",studentList);
        modelAndView.setViewName("Display");
        return modelAndView;
    }
//    删除
    @RequestMapping("/del")
    public ModelAndView del(HttpServletRequest request){
        int sno = Integer.parseInt(request.getParameter("sno"));
        stuInterface.Del(sno);
        return new ModelAndView("redirect:/Display");
    }
//    新增
    @GetMapping("/addPage")
    public ModelAndView addPage(Model model){
        model.addAttribute("student",new Student());
        return new ModelAndView("add","stumodel",model);
    }
    @PostMapping("/add")
    public ModelAndView add(Student student){
        stuInterface.Add(student);
        return new ModelAndView("redirect:/Display");
    }
//    更新
    @GetMapping("/sendsno")
    public ModelAndView sendsno(HttpServletRequest request,Model model){
        int sno = Integer.parseInt(request.getParameter("sno"));
        Student student = stuInterface.selectByPrimaryKey(sno);
        model.addAttribute("student",student);
        return new ModelAndView("Edit","stumodel",model);
    }
    @PostMapping("/update")
    public ModelAndView update(Student student){
        System.out.println(student);
        stuInterface.Update(student);
        return new ModelAndView("redirect:/Display");
    }
}
