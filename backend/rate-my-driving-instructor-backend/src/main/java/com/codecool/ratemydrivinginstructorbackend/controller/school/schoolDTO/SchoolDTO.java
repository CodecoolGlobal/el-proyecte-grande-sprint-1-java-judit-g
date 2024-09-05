package com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;

import java.util.Set;
import java.util.UUID;

public record SchoolDTO(UUID publicId, AddressDTO addressDTO, String name, String phoneNumber, Set<InstructorNameDTO> instructors) {
}
