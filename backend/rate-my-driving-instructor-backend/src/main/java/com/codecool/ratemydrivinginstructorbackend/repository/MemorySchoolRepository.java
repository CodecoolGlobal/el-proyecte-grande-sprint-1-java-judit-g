package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.repository.model.School;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class MemorySchoolRepository implements SchoolRepository {

    private final Set<School> schools;

    public MemorySchoolRepository() {
        schools = new HashSet<>();
    }
    @Override
    public void addSchool(School school) {
        schools.add(school);
    }

    @Override
    public Optional<School> getSchoolById(int schoolId) {
        return schools.stream()
                .filter(school -> school.isId(schoolId))
                .findFirst();
    }

    @Override
    public void updateSchool(School school) {
        Optional<School> optionalSchool = getSchoolById(school.getId());
        if (optionalSchool.isPresent()) {
            schools.remove(optionalSchool.get());
            schools.add(school);
        }
    }

    @Override
    public Set<School> getAllSchools() {
        return Collections.unmodifiableSet(schools);
    }
}
