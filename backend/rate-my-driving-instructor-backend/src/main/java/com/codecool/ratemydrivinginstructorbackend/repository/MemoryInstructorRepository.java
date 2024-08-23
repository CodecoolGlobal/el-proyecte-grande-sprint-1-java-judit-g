package com.codecool.ratemydrivinginstructorbackend.repository;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class MemoryInstructorRepository implements InstructorRepository{

    private Set<Instructor> instructors;

    public MemoryInstructorRepository() {
        this.instructors = new HashSet<>();
    }

    @Override
    public boolean addInstructor(Instructor instructor) {
        return instructors.add(instructor);
    }

    @Override
    public Optional<Instructor> getInstructorById(int instructorId) {
        return instructors.stream()
                .filter(instructor -> instructor.isId(instructorId))
                .findFirst();
    }

    @Override
    public boolean updateInstructor(Instructor instructor) {
        Instructor instructorById = instructors.stream()
                .filter(instructor1 -> instructor1.isId(instructor.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No instructor has been found by the given ID!"));

        instructors.remove(instructorById);

        instructors.add(instructor);
        return true;
    }

    @Override
    public Set<Instructor> getAllInstructors() {
        return Collections.unmodifiableSet(instructors);
    }

    @Override
    public boolean deleteInstructor(int id) {
        Optional<Instructor> optionalInstructor = getInstructorById(id);

        return optionalInstructor
                .map(instructor -> instructors.remove(instructor))
                .orElse(false);
    }
}
