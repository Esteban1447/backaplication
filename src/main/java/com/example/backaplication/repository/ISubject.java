package com.example.backaplication.repository;

import com.example.backaplication.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubject extends JpaRepository<Subject, Integer> {
}
