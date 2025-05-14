package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import com.example.backaplication.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistencias")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    // guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Attendance Data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveAttendance(Data));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
