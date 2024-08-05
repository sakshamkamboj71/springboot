package com.initial.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to the home page " + request.getSession().getId();
    }

    @RequestMapping("/about")
    public String about(){
        return "This is the about page you are viewing";
    }

}
