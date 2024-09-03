package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findBySchoolId(Long schoolId);
}
