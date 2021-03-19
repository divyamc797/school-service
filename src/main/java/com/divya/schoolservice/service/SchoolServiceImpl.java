package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.School;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.SchoolModel;
import com.divya.schoolservice.repository.SchoolRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public SchoolModel createSchool(SchoolModel schoolModel) {
        School school = new School();
//        school.setName(schoolModel.getName());
//        school.setAddress(schoolModel.getAddress());
        BeanUtils.copyProperties(schoolModel, school);
        schoolRepo.save(school);
        schoolModel.setId(school.getId());
        return schoolModel;
    }

    @Override
    public SchoolModel getSchoolById(long id) throws NotFound {
        Optional<School> byId = schoolRepo.findById(id);

        if (byId.isPresent()) {
            SchoolModel schoolModel = new SchoolModel();
            BeanUtils.copyProperties(byId.get(), schoolModel);
            return schoolModel;
        }

        throw new NotFound("resource school with id: " + id + " not found");
    }

    @Override
    public SchoolModel getSchoolByName(String name) throws NotFound {
        Optional<School> byName = schoolRepo.findByNameContainingIgnoreCase(name);

        if (!byName.isPresent()) {
            throw new NotFound("resource school with name: " + name + " not found");
        }

        SchoolModel schoolModel = new SchoolModel();
        BeanUtils.copyProperties(byName.get(), schoolModel);
        return schoolModel;
    }

}
