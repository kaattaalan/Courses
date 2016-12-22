package com.exp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
public interface StudentRepo  extends JpaRepository<Student,Long> {
    public List<Student> findAll();
    public Long deleteBySid(Long sid);
}
