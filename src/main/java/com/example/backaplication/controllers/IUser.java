package com.example.backaplication.controllers;

import com.example.backaplication.models.Attendance;
import com.example.backaplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
}
