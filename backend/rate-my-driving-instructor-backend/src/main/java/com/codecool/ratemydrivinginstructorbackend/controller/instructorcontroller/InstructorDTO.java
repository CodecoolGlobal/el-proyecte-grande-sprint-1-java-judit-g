package com.codecool.ratemydrivinginstructorbackend.controller.instructorcontroller;

import com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.School;

import java.util.Set;

public record InstructorDTO(String firstName, String lastName, School school, Set<Review> reviews) {

}
