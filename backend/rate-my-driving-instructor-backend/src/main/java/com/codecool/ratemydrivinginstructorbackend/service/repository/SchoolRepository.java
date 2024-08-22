package com.codecool.ratemydrivinginstructorbackend.service.repository;

import java.util.Set;

public interface SchoolRepository {
    void addSchool(School school);
    School getSchool(int schoolId);
    void updateSchool(School school);
    Set<School> getAllSchools();
}
