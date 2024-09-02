package com.codecool.ratemydrivinginstructorbackend.controller.controller_advice;

import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorCannotBeCreatedException;
import com.codecool.ratemydrivinginstructorbackend.service.exception.InstructorNotFoundException;
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
    @ExceptionHandler(InstructorCannotBeCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String InstructorCannotBeCreatedExceptionHandler(InstructorCannotBeCreatedException instructorCannotBeCreatedException) {
        return instructorCannotBeCreatedException.getMessage();
    }
}
