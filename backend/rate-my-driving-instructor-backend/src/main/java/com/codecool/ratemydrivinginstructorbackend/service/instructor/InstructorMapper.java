package com.codecool.ratemydrivinginstructorbackend.service.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
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

    public InstructorNameDTO mapInstructorToInstructorNameDTO(Instructor instructor) {
        return new InstructorNameDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getPublicId()
        );
    }
}
