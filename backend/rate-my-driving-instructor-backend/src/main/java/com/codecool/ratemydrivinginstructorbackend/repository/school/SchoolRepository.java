package com.codecool.ratemydrivinginstructorbackend.repository.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByPublicId(UUID publicId);

    Optional<School> deleteByPublicId(UUID publicId);
}
