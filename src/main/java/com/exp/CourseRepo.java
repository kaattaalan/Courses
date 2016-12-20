package com.exp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
public interface CourseRepo extends JpaRepository<Course,Long> {
  List<Course> findById(Long courseId);

}
