package com.exp;

import javax.lang.model.element.PackageElement;
import javax.persistence.*;
import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String cname;


    @OneToMany(mappedBy = "coursetaken")
    private List<Student> students;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void addStudent(Student stud)
    {
        this.students.add(stud);
        if(stud.getCoursetaken()!=this)
        {
            stud.setCoursetaken(this);
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
