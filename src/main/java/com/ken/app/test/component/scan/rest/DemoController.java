package com.ken.app.test.component.scan.rest;

import com.ken.app.test.component.scan.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach myCoach;

    // Qualifiers
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
