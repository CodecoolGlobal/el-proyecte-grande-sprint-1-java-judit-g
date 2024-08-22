package com.codecool.ratemydrivinginstructorbackend.service.repository;

import java.util.Set;

public interface InstructorRepository {
    void addInstructor(Instructor instructor);
    Set<Instructor> getAllInstructors;
    Instructor getInstructorById(int instructorId);
    void updateInstructor(Instructor instructor)
}
