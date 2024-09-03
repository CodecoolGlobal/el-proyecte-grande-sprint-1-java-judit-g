package com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findInstructorByPublicId(UUID publicId);

}
