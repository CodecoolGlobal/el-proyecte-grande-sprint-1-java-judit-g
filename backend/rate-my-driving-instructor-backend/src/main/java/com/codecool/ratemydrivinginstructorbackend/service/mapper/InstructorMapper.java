package com.codecool.ratemydrivinginstructorbackend.service.mapper;

import com.codecool.ratemydrivinginstructorbackend.controller.dto.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.dto.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.model.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.model.school.School;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    public Instructor mapNewInstructorDTOToInstructor(NewInstructorDTO newInstructorDTO, School school) {
        return new Instructor(
                newInstructorDTO.firstName(),
                newInstructorDTO.lastName(),
                school);
    }

    public Instructor mapInstructorDTOToInstructor(InstructorDTO instructorDTO) {
        return new Instructor(
                instructorDTO.firstName(),
                instructorDTO.lastName(),
                instructorDTO.reviews(),
                instructorDTO.school()
        );
    }

    public InstructorDTO mapInstructorToInstructorDTO(Instructor instructor) {
        return new InstructorDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSchool(),
                instructor.getReviews()
        );
    }
}
