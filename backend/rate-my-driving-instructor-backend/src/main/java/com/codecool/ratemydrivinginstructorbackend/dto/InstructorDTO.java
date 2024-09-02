package com.codecool.ratemydrivinginstructorbackend.dto;

import com.codecool.ratemydrivinginstructorbackend.model.Review;
import com.codecool.ratemydrivinginstructorbackend.model.School;

import java.util.List;

public record InstructorDTO(String firstName, String lastName, School school, List<Review> reviews) {}
