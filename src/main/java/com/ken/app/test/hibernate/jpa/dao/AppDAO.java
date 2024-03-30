package com.ken.app.test.hibernate.jpa.dao;

import com.ken.app.test.hibernate.jpa.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);
}
