package com.example.backaplication.controllers;

import com.example.backaplication.models.Tuition;
import com.example.backaplication.services.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas")
public class TuitionController {

    @Autowired
    private TuitionService service;

    // guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Tuition Data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveTuition(Data));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
