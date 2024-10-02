package com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorForAdminDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReviewForAdminDTO(UUID publicId, String description, int rating, LocalDateTime publishingTime, InstructorForAdminDTO instructor) {
}
