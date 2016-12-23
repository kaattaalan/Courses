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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MY_COURSE")
    private Course coursetaken;



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

    public Course getCoursetaken() {
        return coursetaken;
    }

    public void setCoursetaken(Course coursetaken) {
        this.coursetaken = coursetaken;
        if(!coursetaken.getStudents().contains(this))
        {
            coursetaken.getStudents().add(this);
        }
    }
}
