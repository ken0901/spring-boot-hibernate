package com.ken.app.test.hibernate.jpa.dao;

import com.ken.app.test.hibernate.jpa.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
