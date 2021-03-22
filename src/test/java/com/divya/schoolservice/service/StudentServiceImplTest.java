package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.StudentModel;
import com.divya.schoolservice.repository.SchoolRepo;
import com.divya.schoolservice.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class StudentServiceImplTest {
    private School school;
    private StudentModel StudentModel;

    @InjectMocks
    private StudentService studentService = new StudentServiceImpl();

    @Mock
    private SchoolRepo schoolRepo;

    @Mock
    private StudentRepo studentRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        school = new School();
        StudentModel = new StudentModel();
    }

    @Test
    public void testCreateStudent() throws NotFound {
        StudentModel studentModel = new StudentModel();
        Mockito.when(schoolRepo.findById(Mockito.any())).thenReturn(Optional.of(school));
        StudentModel response = studentService.createStudent(studentModel);
        Assertions.assertEquals(0, response.getId());
    }

    @Test
    public void testCreateStudentWhenSchoolNotFound() {
        Mockito.when(schoolRepo.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
        Assertions.assertThrows(NotFound.class, () -> studentService.createStudent(StudentModel));
    }
}