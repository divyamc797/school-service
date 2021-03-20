package com.divya.schoolservice.service;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.TeacherModel;

public interface TeacherService {
    TeacherModel createTeacher(TeacherModel teacherModel) throws NotFound;
}
