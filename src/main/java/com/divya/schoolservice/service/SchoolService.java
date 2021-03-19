package com.divya.schoolservice.service;

import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.model.SchoolModel;

public interface SchoolService {
    SchoolModel createSchool(SchoolModel schoolModel);

    SchoolModel getSchoolById(long id) throws NotFound;

    SchoolModel getSchoolByName(String name) throws NotFound;
}
