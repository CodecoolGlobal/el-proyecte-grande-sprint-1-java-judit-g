package com.codecool.ratemydrivinginstructorbackend.controller.dto.school;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.instructor.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.Address;

import java.util.Set;

public record SchoolDTO(AddressDTO addressDTO, String name, String phoneNumber, Set<InstructorNameDTO> instructors) {
}
