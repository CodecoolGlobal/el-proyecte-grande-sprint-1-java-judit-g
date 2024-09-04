package com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO;

import java.util.UUID;

public record InstructorNameDTO(String firstName, String lastName, UUID publicId) {
}
