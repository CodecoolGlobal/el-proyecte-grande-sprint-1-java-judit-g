package com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;

import java.util.Set;

public record SchoolDTO(AddressDTO addressDTO, String name, String phoneNumber, Set<InstructorNameDTO> instructors) {
}
