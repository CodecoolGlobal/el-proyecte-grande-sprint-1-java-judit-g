package com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

    Optional<Reviewer> findByPublicId(UUID publicId);
}
