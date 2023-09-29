package com.ken.app.test.field.injection;

import com.ken.app.test.component.scan.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class FieldController {

    //@Autowired
    private Coach myCoach;

    // no need for constructors or setters

    //@GetMapping("/field")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
