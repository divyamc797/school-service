package com.divya.schoolservice.controller;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.TeacherModel;
import com.divya.schoolservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<TeacherModel> create(@RequestBody TeacherModel teacherModel) throws NotFound {
        return ResponseEntity.created(null).body(teacherService.createTeacher(teacherModel));
    }
}
