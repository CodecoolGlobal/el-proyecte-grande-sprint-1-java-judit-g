package com.codecool.ratemydrivinginstructorbackend.service.mapper;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    public Instructor mapNewInstructorDTOToInstructor(NewInstructorDTO newInstructorDTO, School school) {
        return new Instructor(
                newInstructorDTO.firstName(),
                newInstructorDTO.lastName(),
                school,
                newInstructorDTO.licenseTypeSet());
    }

    public Instructor mapInstructorDTOToInstructor(InstructorDTO instructorDTO) {
        return new Instructor(
                instructorDTO.firstName(),
                instructorDTO.lastName(),
                instructorDTO.school(),
                instructorDTO.reviews(),
                instructorDTO.licenseTypeSet()
        );
    }

    public InstructorDTO mapInstructorToInstructorDTO(Instructor instructor) {
        return new InstructorDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSchool(),
                instructor.getReviews(),
                instructor.getLicenseType()
        );
    }
}
