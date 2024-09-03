package com.codecool.ratemydrivinginstructorbackend.service.instructor.exception;

public class InstructorNotFoundException extends RuntimeException {

    public InstructorNotFoundException() {
        super("Instructor was not found");
    }
}
