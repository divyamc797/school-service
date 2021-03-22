package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.entities.Student;
import com.divya.schoolservice.entities.Teacher;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.SchoolModel;
import com.divya.schoolservice.repository.SchoolRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

public class SchoolServiceImplTest {
    private School school;
    private Teacher teacher;
    private Student student;

    @InjectMocks
    private SchoolService schoolService = new SchoolServiceImpl();

    @Mock
    private SchoolRepo schoolRepo;

    @BeforeEach
    public void setUp() {
        // to inject above annonted mock objects from Mockito framework
        MockitoAnnotations.openMocks(this);
        school = new School();
        school.setName("school");
        teacher = new Teacher();
        teacher.setName("teacher");
        student = new Student();
        student.setName("student");
    }

    @Test
    public void testCreateSchool() {
        SchoolModel schoolModel = new SchoolModel();
        Mockito.when(schoolRepo.save(Mockito.any())).thenReturn(null);
        schoolModel = schoolService.createSchool(schoolModel);
        Assertions.assertEquals(0, schoolModel.getId());
    }

    @Test
    public void testGetSchoolById() throws NotFound {
        Mockito.when(schoolRepo.findById(1L)).thenReturn(Optional.of(school));
        SchoolModel response = schoolService.getSchoolById(1L);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.getId());
    }

    @Test
    public void testGetSchoolByIdWhenTeachersPresent() throws NotFound {
        List<Teacher> teachers = List.of(teacher);
        school.setTeachers(teachers);
        Mockito.when(schoolRepo.findById(1L)).thenReturn(Optional.of(school));
        SchoolModel response = schoolService.getSchoolById(1L);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.getId());
        Assertions.assertEquals(1, response.getTeacherModels().size());
        Assertions.assertEquals("teacher", response.getTeacherModels().get(0).getName());
    }

    @Test
    public void testGetSchoolByIdWhenStudentPresent() throws NotFound {
        List<Student> students = List.of(student);
        school.setStudents(students);
        Mockito.when(schoolRepo.findById(1L)).thenReturn(Optional.of(school));
        SchoolModel response = schoolService.getSchoolById(1L);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.getId());
        Assertions.assertEquals(1, response.getStudentModels().size());
        Assertions.assertEquals("student", response.getStudentModels().get(0).getName());
    }

    @Test
    public void testGetSchoolByIdWhenSchoolNotExists() throws NotFound {
        Mockito.when(schoolRepo.findById(1L)).thenReturn(Optional.ofNullable(null));
        Assertions.assertThrows(NotFound.class, () -> schoolService.getSchoolById(1L));
    }

    @Test
    public void testGetSchoolByName() throws NotFound {
        Mockito.when(schoolRepo.findByNameContainingIgnoreCase("school")).thenReturn(Optional.of(school));
        SchoolModel response = schoolService.getSchoolByName("school");
        Assertions.assertNotNull(response);
        Assertions.assertEquals("school", response.getName());
    }

    @Test
    public void testGetSchoolByNameWhenSchoolNotFound() {
        Mockito.when(schoolRepo.findByNameContainingIgnoreCase("school")).thenReturn(Optional.ofNullable(null));
        Assertions.assertThrows(NotFound.class, () -> schoolService.getSchoolByName("school"));
    }
}