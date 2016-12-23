package com.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String studHome(Model model){
        model.addAttribute("courseList",crepo.findAll());
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
    public String insertStudent(@RequestParam("courseID") String cname, Student student,Model model)
    {
        Course cc=crepo.findByCname(cname);
        student.setCourse(cc);
        srepo.save(student);
        List<Student> lS=srepo.findAll();
        model.addAttribute("students",lS);
        return "showStudent";
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
    @RequestMapping(value = "DeleteStudent/{stdid}")
    public String deleS(@PathVariable("stdid")Long studid)
    {
        srepo.deleteBySid(studid);
        return "showStudent";
    }
    @RequestMapping(value = "DeleteCourse/{crsid}")
    public String deleC(@PathVariable("crsid")Long coursedid)
    {
        crepo.deleteByCid(coursedid);
        return "showStudent";
    }

}
