package com.ken.app.test.hibernate.jpa.dao;

import com.ken.app.test.hibernate.jpa.entity.Course;
import com.ken.app.test.hibernate.jpa.entity.Instructor;
import com.ken.app.test.hibernate.jpa.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
}
