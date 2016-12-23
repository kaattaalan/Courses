package com.exp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by appu on 16/12/16.
 */
public interface StudentRepo  extends JpaRepository<Student,Long> {
    public List<Student> findAll();
    @Modifying
    @Transactional
    public void deleteBySid(Long sid);
}
