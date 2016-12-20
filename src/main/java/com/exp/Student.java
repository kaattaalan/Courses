package com.exp;

import javax.persistence.*;

/**
 * Created by appu on 16/12/16.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;
    private  String sname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid")
    private Course course;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
