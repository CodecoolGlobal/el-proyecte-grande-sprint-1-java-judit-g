package com.codecool.ratemydrivinginstructorbackend.dto;

public record InstructorDTO(String firstName, String lastName, School school, List<Review> reviews) {}
