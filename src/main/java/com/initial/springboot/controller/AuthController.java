package com.initial.springboot.controller;

import com.initial.springboot.model.Users;
import com.initial.springboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "Successfully loggedin in auth";
    }

    @GetMapping("/get-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
