package com.ken.app.test.component.scan.common;

import org.springframework.stereotype.Component;

//@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
