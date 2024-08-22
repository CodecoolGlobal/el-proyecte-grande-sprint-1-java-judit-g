package com.codecool.ratemydrivinginstructorbackend.service.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MemorySchoolRepository implements SchoolRepository {

    private Set<School> schools;

    public MemorySchoolRepository() {
        schools = new HashSet<>(School);
    }
    @Override
    public void addSchool(School school) {
        schools.add(school);
    }

    @Override
    public School getSchool(int schoolId) {
        return schools.stream()
                .filter(school -> school.isSchoolById(schoolId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No school has been found by the given ID:") + schoolId);
    }

    @Override
    public void updateSchool(School school) {
        School schoolById = getSchool(school.schoolId);
        schools.remove(schoolById);
        schools.add(school);
    }

    @Override
    public Set<School> getAllSchools() {
        return Collections.unmodifiableSet(schools);
    }
}
