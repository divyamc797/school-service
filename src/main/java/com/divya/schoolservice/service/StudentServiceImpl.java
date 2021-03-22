package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.entities.Student;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.StudentModel;
import com.divya.schoolservice.repository.SchoolRepo;
import com.divya.schoolservice.repository.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentModel createStudent(StudentModel studentModel) throws NotFound {
        Optional<School> optionalSchool = schoolRepo.findById(studentModel.getSchoolId());
        if (optionalSchool.isPresent()) {
            Student student = new Student();
            BeanUtils.copyProperties(studentModel, student);
            student.setSchool(optionalSchool.get());
            studentRepo.save(student);
            studentModel.setId(student.getId());
            return studentModel;
        }
        throw new NotFound("Resource school not found for an id: " + studentModel.getSchoolId());
    }
}
