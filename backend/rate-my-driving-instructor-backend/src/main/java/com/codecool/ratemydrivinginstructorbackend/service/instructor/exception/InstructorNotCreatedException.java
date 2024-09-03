package com.codecool.ratemydrivinginstructorbackend.service.instructor.exception;

public class InstructorNotCreatedException extends RuntimeException {
    public InstructorNotCreatedException() {
        super("Instructor cannot be created");
    }
}
