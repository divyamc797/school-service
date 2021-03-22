package com.divya.schoolservice.controller;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.StudentModel;
import com.divya.schoolservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentModel> create(@RequestBody StudentModel studentModel) throws NotFound {
        return ResponseEntity.created(null)
                .body(studentService.createStudent(studentModel));
    }
}
