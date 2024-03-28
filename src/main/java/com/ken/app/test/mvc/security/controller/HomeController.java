package com.ken.app.test.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(){
        return "securityTemplate/home";
    }

    // add a request mappping for /leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "securityTemplate/leaders";
    }

    // add a request mappping for /leaders
    @GetMapping("/systems")
    public String showSystems(){
        return "securityTemplate/systems";
    }
}
