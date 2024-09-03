package com.codecool.ratemydrivinginstructorbackend.controller.instructor;

import com.codecool.ratemydrivinginstructorbackend.service.instructor.exception.InstructorNotCreatedException;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.exception.InstructorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InstructorControllerAdvice {

    @ResponseBody
    @ExceptionHandler(InstructorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String instructorNotFoundExceptionHandler(InstructorNotFoundException instructorNotFoundException) {
        return instructorNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InstructorNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String InstructorCannotBeCreatedExceptionHandler(InstructorNotCreatedException instructorNotCreatedException) {
        return instructorNotCreatedException.getMessage();
    }
}
