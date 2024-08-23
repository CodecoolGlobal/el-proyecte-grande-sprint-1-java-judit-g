package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Instructor;

import java.util.Optional;
import java.util.Set;

public interface InstructorRepository {

    boolean addInstructor(Instructor instructor);

    Set<Instructor> getAllInstructors();

    Optional<Instructor> getInstructorById(int instructorId);

    boolean updateInstructor(Instructor instructor);

    boolean deleteInstructor(int id);
}
