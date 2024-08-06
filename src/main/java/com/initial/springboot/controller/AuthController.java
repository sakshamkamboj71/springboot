package com.initial.springboot.controller;

import com.initial.springboot.model.Users;
import com.initial.springboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user){
        System.out.println(user);
        return userService.verify(user);
    }

    @GetMapping("/get-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User registered Successfully");
    }



}
