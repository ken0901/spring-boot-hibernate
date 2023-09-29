package com.ken.app.test.setter.injection.rest;

import com.ken.app.test.setter.injection.common.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class SetterController {

    // Define a private field for the dependency
    private Teacher myTeacher;

    // Setter Injection
    @Autowired
    public void setTeacher(Teacher theTeacher){
        myTeacher = theTeacher;
    }


    @GetMapping("/dailyStudying")
    public String getDailyStudying(){
        return myTeacher.getMathSkill();
    }
}
