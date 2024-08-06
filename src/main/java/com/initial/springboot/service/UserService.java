package com.initial.springboot.service;

import com.initial.springboot.model.Users;
import com.initial.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void addUser(Users user) {
        Users findUsername = repo.findByUsername(user.getUsername());

        if(findUsername == null) {
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
        }
    }

    public ResponseEntity<String> verify(Users user) {

        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(user);
                return ResponseEntity.ok(token);
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The user is unauthorized");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The user is unauthorized");
    }
}
