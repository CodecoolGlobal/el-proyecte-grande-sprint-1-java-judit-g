package com.codecool.ratemydrivinginstructorbackend.controller.dto.school;

import com.codecool.ratemydrivinginstructorbackend.repository.model.school.Address;

public record NewSchoolDTO(Address address, String name, String phoneNumber) {
}
