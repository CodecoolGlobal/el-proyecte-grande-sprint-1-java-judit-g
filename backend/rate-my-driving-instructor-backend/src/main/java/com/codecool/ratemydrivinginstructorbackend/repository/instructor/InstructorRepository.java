package com.codecool.ratemydrivinginstructorbackend.repository.instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Set<Instructor>> getAllInstructorsBySchoolPublicId(UUID schoolId);

    Optional<Instructor> findInstructorByPublicId(UUID publicId);

    void deleteByPublicId(UUID publicID);
}
