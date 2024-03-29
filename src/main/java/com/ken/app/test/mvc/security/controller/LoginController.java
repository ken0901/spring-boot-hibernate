package com.ken.app.test.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){

        return "securityTemplate/fancy-login";
    }

    // add request mapping for /access-denied
    @GetMapping("access-denied")
    public String showAccessDenied(){
        return "securityTemplate/access-denied";
    }
}
