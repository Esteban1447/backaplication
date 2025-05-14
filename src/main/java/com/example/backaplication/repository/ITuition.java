package com.example.backaplication.repository;

import com.example.backaplication.models.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITuition extends JpaRepository<Tuition, Integer> {
}
