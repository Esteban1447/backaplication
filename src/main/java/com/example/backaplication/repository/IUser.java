package com.example.backaplication.repository;

import com.example.backaplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
}
