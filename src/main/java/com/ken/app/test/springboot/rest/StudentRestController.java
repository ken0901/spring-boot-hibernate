package com.ken.app.test.springboot.rest;

import com.ken.app.test.springboot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Ken", "Lee"));
        theStudents.add(new Student("Katie", "Lee"));
        theStudents.add(new Student("John", "Doe"));
        return theStudents;
    }
}
