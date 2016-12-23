package com.exp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
public interface CourseRepo extends JpaRepository<Course,Long> {
    List<Course> findAll();
    Course findByCname(String cname);
    @Modifying
    void deleteByCid(Long cid);
}
