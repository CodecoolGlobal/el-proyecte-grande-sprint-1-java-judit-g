package com.codecool.ratemydrivinginstructorbackend.controller.dto;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.model.School;

import java.util.Set;

public record InstructorDTO(String firstName, String lastName, School school, Set<Review> reviews) {

}
