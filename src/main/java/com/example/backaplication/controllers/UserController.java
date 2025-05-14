package com.example.backaplication.controllers;

import com.example.backaplication.models.User;
import com.example.backaplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    // guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody User Data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveUser(Data));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
