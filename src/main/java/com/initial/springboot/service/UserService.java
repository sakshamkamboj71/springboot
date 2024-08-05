package com.initial.springboot.service;

import com.initial.springboot.model.Users;
import com.initial.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void addUser(Users user) {
        Users findUsername = repo.findByUsername(user.getUsername());

        if(findUsername == null) {
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
        }
    }
}
