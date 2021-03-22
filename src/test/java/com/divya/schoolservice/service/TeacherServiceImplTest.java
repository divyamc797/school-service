package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.TeacherModel;
import com.divya.schoolservice.repository.SchoolRepo;
import com.divya.schoolservice.repository.TeacherRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherServiceImplTest {
    private School school;
    private TeacherModel teacherModel;

    @InjectMocks
    private TeacherService teacherService = new TeacherServiceImpl();

    @Mock
    private SchoolRepo schoolRepo;

    @Mock
    private TeacherRepo teacherRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        school = new School();
        teacherModel = new TeacherModel();
    }

    @Test
    public void testCreateTeacher() throws NotFound {
        TeacherModel teacherModel = new TeacherModel();
        Mockito.when(schoolRepo.findById(Mockito.any())).thenReturn(Optional.of(school));
        TeacherModel response = teacherService.createTeacher(teacherModel);
        Assertions.assertEquals(0, response.getId());
    }

    @Test
    public void testCreateTeacherWhenSchoolNotFound() {
        Mockito.when(schoolRepo.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
        Assertions.assertThrows(NotFound.class, () -> teacherService.createTeacher(teacherModel));
    }
}