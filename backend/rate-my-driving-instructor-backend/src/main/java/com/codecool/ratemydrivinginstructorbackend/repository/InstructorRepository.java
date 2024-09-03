package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByName(String name);
    Optional<Set<Instructor>> getAllInstructorsBySchoolId(Long schoolId);
    void save(NewInstructorDTO newInstructorDTO);
}
