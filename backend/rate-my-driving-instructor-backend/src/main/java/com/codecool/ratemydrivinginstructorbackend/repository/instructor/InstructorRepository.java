package com.codecool.ratemydrivinginstructorbackend.repository.instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Set<Instructor> getAllInstructorsBySchoolPublicId(UUID schoolId);

    Optional<Instructor> findByPublicId(UUID publicId);

    void deleteByPublicId(UUID publicID);

    List<Instructor> findByFirstNameContainingOrLastNameContaining(String name1, String name2);
}
