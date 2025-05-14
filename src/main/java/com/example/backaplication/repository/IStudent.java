package com.example.backaplication.repository;

import com.example.backaplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudent extends JpaRepository<Student, Integer> {
}
