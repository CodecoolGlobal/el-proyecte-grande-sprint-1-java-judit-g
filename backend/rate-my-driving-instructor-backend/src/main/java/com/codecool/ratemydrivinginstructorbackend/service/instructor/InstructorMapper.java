package com.codecool.ratemydrivinginstructorbackend.service.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolNameDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InstructorMapper {

    public Instructor mapNewInstructorDTOToInstructor(NewInstructorDTO newInstructorDTO, School school) {
        return new Instructor(
                newInstructorDTO.firstName(),
                newInstructorDTO.lastName(),
                school,
                newInstructorDTO.licenseTypeSet());
    }

    public InstructorDTO mapInstructorToInstructorDTO(Instructor instructor, SchoolMapper schoolMapper, ReviewMapper reviewMapper) {
        return new InstructorDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                schoolMapper.mapSchoolToSchoolNameDTO(instructor.getSchool()),
                mapReviewsToReviewDTOs(instructor.getReviews(), reviewMapper),
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

    public Set<InstructorNameDTO> mapInstructorsToNameDTOs(Set<Instructor> instructors) {
        return instructors.stream()
                .map(this::mapInstructorToInstructorNameDTO)
                .collect(Collectors.toSet());
    }

    private Set<ReviewDTO> mapReviewsToReviewDTOs(Set<Review> reviews, ReviewMapper reviewMapper) {
        return  reviews.stream()
                .map(reviewMapper::mapReviewToReviewDTO)
                .collect(Collectors.toSet());
    }
}
