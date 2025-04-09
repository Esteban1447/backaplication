package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import com.example.backaplication.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourse extends JpaRepository<Course, Integer> {
}
