package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.entities.Teacher;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.TeacherModel;
import com.divya.schoolservice.repository.SchoolRepo;
import com.divya.schoolservice.repository.TeacherRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public TeacherModel createTeacher(TeacherModel teacherModel) throws NotFound {

        Optional<School> optionalSchool = schoolRepo.findById(teacherModel.getSchoolId());
        if (optionalSchool.isPresent()) {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherModel, teacher);
            teacher.setSchool(optionalSchool.get());
            teacherRepo.save(teacher);
            teacherModel.setId(teacher.getId());
            return teacherModel;
        }
        throw new NotFound("School for the id: " + teacherModel.getSchoolId() + " not found");
    }

}
