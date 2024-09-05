package com.codecool.ratemydrivinginstructorbackend.service.reviewer.exception;

public class ReviewerNotFoundException extends RuntimeException {
    public ReviewerNotFoundException(String message) {
        super(message);
    }
}
