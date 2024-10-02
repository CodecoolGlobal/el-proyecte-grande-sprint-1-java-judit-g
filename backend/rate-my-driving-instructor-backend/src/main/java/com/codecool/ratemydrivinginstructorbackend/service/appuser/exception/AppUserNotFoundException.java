package com.codecool.ratemydrivinginstructorbackend.service.appuser.exception;

public class AppUserNotFoundException extends RuntimeException {
    public AppUserNotFoundException(String message) {
        super(message);
    }
}
