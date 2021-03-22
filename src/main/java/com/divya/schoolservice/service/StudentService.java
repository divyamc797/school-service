package com.divya.schoolservice.service;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.StudentModel;

public interface StudentService {
    StudentModel createStudent(StudentModel studentModel) throws NotFound;
}
