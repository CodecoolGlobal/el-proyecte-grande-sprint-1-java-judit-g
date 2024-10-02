package com.codecool.ratemydrivinginstructorbackend.repository.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewerRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByPublicId(UUID publicId);

    Optional<AppUser> findByUsername(String username);

    void deleteByPublicId(UUID publicId);

    Optional<AppUser> findUserByUsername(String username);
}
