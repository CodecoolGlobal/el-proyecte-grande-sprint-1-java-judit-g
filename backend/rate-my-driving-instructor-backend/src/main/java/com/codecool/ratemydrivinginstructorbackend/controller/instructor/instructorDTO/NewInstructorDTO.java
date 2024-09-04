package com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;

import java.util.Set;
import java.util.UUID;

public record NewInstructorDTO(String firstName, String lastName, UUID schoolPublicId, Set<LicenseType> licenseTypeSet) {
}
