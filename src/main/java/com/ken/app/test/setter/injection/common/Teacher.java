package com.ken.app.test.setter.injection.common;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements Teach {

    @Override
    public String getMathSkill() {
        return "Practice Multiply for 15 minutes";
    }
}
