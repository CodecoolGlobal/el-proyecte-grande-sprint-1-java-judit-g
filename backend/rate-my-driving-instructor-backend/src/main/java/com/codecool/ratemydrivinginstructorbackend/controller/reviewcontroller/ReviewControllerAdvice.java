package com.codecool.ratemydrivinginstructorbackend.controller.reviewcontroller;

import com.codecool.ratemydrivinginstructorbackend.service.reviewservice.exception.ReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReviewControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ReviewNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String reviewNotFoundExceptionHandler(ReviewNotFoundException reviewNotFoundException) {
        return reviewNotFoundException.getMessage();
    }
}
