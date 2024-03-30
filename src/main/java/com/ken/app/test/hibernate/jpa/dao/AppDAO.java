package com.ken.app.test.hibernate.jpa.dao;

import com.ken.app.test.hibernate.jpa.entity.Instructor;
import com.ken.app.test.hibernate.jpa.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
