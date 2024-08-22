package com.codecool.ratemydrivinginstructorbackend.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MemoryInstructorRepository implements InstructorRepository{

    private Set<Instructor> instructors;

    public MemoryInstructorRepository() {
        instructors = new HashSet<>(Instructor);
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    @Override
    public Instructor getInstructorById(int instructorId) {
        return instructors.stream()
                .filter(instructor -> instructor.isInstructorById(instructorId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No instructor has been found by the given ID:" + instructorId));
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        Instructor instructorById = instructors.stream()
                .filter(instructor1 -> instructor1.isInstructorById(instructor.getId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No instructor has been found by the given ID!"));

        instructors.remove(instructorById);

        instructors.add(instructor);
    }

    @Override
    public Set<Instructor> getAllInstructors() {
        return Collections.unmodifiableSet(instructors);
    }
}
