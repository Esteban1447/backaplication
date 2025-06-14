package com.example.backaplication.repository;

import com.example.backaplication.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacher extends JpaRepository<Teacher, Integer> {
}
