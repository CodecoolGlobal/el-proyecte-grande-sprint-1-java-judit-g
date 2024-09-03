package com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO;


import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;

import java.util.Set;

public record InstructorDTO(String firstName, String lastName, SchoolNameDTO schoolNameDTO, Set<ReviewDTO> reviewDTOs, Set<LicenseType> licenseTypeSet) {

}
