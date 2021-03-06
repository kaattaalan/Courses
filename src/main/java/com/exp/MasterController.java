package com.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
@Controller
@RequestMapping("/")
public class MasterController {
    @RequestMapping("/")
    public String startPage(){
        return "index";
    }
    @Autowired
    StudentRepo srepo;

    @RequestMapping("student")                              //index page management
    public String studHome(){
        return "studentHome";
    }
    @Autowired
    CourseRepo crepo;
    @RequestMapping("course")
    public String courseHome()
    {
        return "courseHome";
    }

   //insert into Db
        @RequestMapping(value = "addCourse")
        public String insertCourse(Course course)
        {
            crepo.save(course);
            return "courseHome";
        }

    @RequestMapping(value = "addStudent")
    public String insertStudent(Student student)
    {
        srepo.save(student);
        return "studentHome";
    }


    //read From Db

    @RequestMapping("showCRS")
    public String showC(Model model)
    {
        List<Course> lC=crepo.findAll();
        model.addAttribute("courses",lC);

        return "showCourse";
    }

    @RequestMapping("showSTD")
    public String showS(Model model)
    {
        List<Student> lS=srepo.findAll();
        model.addAttribute("students",lS);
        return "showStudent";
    }

}
