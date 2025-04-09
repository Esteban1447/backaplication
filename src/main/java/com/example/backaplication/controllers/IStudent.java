package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import com.example.backaplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudent extends JpaRepository<Student, Integer> {
}
