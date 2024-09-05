package com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO;


import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;

import java.util.Set;
import java.util.UUID;

public record InstructorDTO(UUID publicID, String firstName, String lastName, SchoolNameDTO schoolNameDTO, Set<ReviewDTO> reviewDTOs, Set<LicenseType> licenseTypeSet) {

}
