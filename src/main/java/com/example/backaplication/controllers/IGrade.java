package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import com.example.backaplication.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrade extends JpaRepository<Grade, Integer> {
}
