package com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;

import java.util.UUID;

public record InstructorForAdminDTO(UUID publicId, String firstName, String lastName, SchoolNameDTO schoolName) {
}
