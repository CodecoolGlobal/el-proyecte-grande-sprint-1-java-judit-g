package com.codecool.ratemydrivinginstructorbackend.controller.dto.school;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.Address;

import java.util.Set;

public record SchoolDTO(Address address, String name, String phoneNumber, Set<InstructorDTO> instructors) {
}
