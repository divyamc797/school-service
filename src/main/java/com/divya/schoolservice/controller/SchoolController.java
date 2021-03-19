package com.divya.schoolservice.controller;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.SchoolModel;
import com.divya.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create")
    public ResponseEntity<SchoolModel> saveSchool(@RequestBody SchoolModel schoolModel) {
        return ResponseEntity.created(null).body(schoolService.createSchool(schoolModel));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SchoolModel> getById(@PathVariable long id) throws NotFound {
        return ResponseEntity.ok().body(schoolService.getSchoolById(id));
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<SchoolModel> getByName(@PathVariable String name) throws NotFound {
        return ResponseEntity.ok().body(schoolService.getSchoolByName(name));
    }
}
