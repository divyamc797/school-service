package com.divya.schoolservice.repository;

import com.divya.schoolservice.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
