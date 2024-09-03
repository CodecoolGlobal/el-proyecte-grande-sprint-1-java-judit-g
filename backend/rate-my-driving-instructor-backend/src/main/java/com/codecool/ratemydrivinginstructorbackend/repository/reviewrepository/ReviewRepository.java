package com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByInstructorFirstNameAndInstructorLastName(String firstName, String lastName);

    Optional<Review> findByPublicId(UUID publicId);
}
