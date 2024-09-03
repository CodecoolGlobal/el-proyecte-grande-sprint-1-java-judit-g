package com.codecool.ratemydrivinginstructorbackend.service.mapper;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.model.instructor.InstructorEntity;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    public InstructorEntity mapNewInstructorDTOToInstructor(NewInstructorDTO newInstructorDTO, School school) {
        return new InstructorEntity(
                newInstructorDTO.firstName(),
                newInstructorDTO.lastName(),
                school,
                newInstructorDTO.licenseTypeSet());
    }

    public InstructorEntity mapInstructorDTOToInstructor(InstructorDTO instructorDTO) {
        return new InstructorEntity(
                instructorDTO.firstName(),
                instructorDTO.lastName(),
                instructorDTO.school(),
                instructorDTO.reviews(),
                instructorDTO.licenseTypeSet()
        );
    }

    public InstructorDTO mapInstructorToInstructorDTO(InstructorEntity instructor) {
        return new InstructorDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSchool(),
                instructor.getReviews(),
                instructor.getLicenseType()
        );
    }
}
