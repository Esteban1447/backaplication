package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendance extends JpaRepository<Attendance, Integer> {
}
