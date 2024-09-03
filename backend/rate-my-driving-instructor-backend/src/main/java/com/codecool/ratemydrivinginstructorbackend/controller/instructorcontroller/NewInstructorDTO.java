package com.codecool.ratemydrivinginstructorbackend.controller.instructorcontroller;

import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.LicenseType;

import java.util.Set;

public record NewInstructorDTO(String firstName, String lastName, Long schoolId, Set<LicenseType> licenseTypeSet) {
}
