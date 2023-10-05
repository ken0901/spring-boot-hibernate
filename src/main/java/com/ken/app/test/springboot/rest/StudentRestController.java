package com.ken.app.test.springboot.rest;

import com.ken.app.test.springboot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //Define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Ken", "Lee"));
        theStudents.add(new Student("Katie", "Lee"));
        theStudents.add(new Student("John", "Doe"));
    }

    //Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudents;
    }

    //Define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Just index into the list ... keep it simple for now
        return theStudents.get(studentId);
    }
}
