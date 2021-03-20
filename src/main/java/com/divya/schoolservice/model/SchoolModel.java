package com.divya.schoolservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolModel {
    private long id;
    private String name;
    private String address;

    private List<TeacherModel> teacherModels;

    public List<TeacherModel> getTeacherModels() {
        return teacherModels;
    }

    public void setTeacherModels(List<TeacherModel> teacherModels) {
        this.teacherModels = teacherModels;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
