package com.codecool.ratemydrivinginstructorbackend.service.mapper;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.school.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.school.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School mapNewSchoolDTOToSchool(NewSchoolDTO newSchoolDTO) {
        return new School(
                newSchoolDTO.name(),
                newSchoolDTO.phoneNumber());
    }

    public School updateSchoolFromDTO(SchoolDTO schoolDTO, School school) {
        school.setInstructors(schoolDTO.instructors());
        school.setName(schoolDTO.name());
        school.setPhoneNumber(schoolDTO.phoneNumber());
        school.setAddress(schoolDTO.address());
        return school;
    }

    public SchoolDTO mapSchoolToSchoolDTO(School school) {
        return new SchoolDTO(
                school.getAddress(),
                school.getName(),
                school.getPhoneNumber(),
                school.getInstructors()
        );
    }
}
