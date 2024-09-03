package com.codecool.ratemydrivinginstructorbackend.controller.dto;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;

import java.util.Set;

public record InstructorDTO(String firstName, String lastName, School school, Set<Review> reviews, Set<LicenseType> licenseTypeSet) {

}
