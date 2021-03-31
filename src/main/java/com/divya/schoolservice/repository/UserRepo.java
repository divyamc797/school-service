package com.divya.schoolservice.repository;

import com.divya.schoolservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> getUserByName(final String name);
}
