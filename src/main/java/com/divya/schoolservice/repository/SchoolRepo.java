package com.divya.schoolservice.repository;

import com.divya.schoolservice.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
    Optional<School> findByNameContainingIgnoreCase(String name);
}
