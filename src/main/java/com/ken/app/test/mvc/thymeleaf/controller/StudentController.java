package com.ken.app.test.mvc.thymeleaf.controller;

import com.ken.app.test.mvc.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguages;

    @Value("${favoriteSystem}")
    private List<String> favoriteSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of languages to the model
        theModel.addAttribute("favoriteLanguages", favoriteLanguages);

        // add the list of system to the model
        theModel.addAttribute("favoriteSystems", favoriteSystems);

        return "student-form";
    }

    @PostMapping("processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        // log the input data
        System.out.println("theStudent: "+theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
