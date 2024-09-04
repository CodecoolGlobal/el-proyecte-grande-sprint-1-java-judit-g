package com.codecool.ratemydrivinginstructorbackend.controller.dto.school;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.Address;

import java.util.Set;

public record NewSchoolDTO(Address address, String name, String phoneNumber) {
}