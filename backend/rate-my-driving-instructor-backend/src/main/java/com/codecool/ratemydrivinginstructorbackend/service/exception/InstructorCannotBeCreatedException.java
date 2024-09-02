package com.codecool.ratemydrivinginstructorbackend.service.exception;

public class InstructorCannotBeCreatedException extends RuntimeException {
    public InstructorCannotBeCreatedException() {
        super("Instructor cannot be created");
    }
}
