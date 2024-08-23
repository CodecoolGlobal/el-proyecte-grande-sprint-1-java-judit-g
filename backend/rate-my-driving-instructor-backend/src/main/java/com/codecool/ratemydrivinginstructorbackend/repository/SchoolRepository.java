package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.repository.model.School;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SchoolRepository {
    void addSchool(School school);

    Optional<School> getSchoolById(int schoolId);

    void updateSchool(School school);

    Set<School> getAllSchools();
}
