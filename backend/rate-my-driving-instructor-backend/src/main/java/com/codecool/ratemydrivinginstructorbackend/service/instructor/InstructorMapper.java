package com.codecool.ratemydrivinginstructorbackend.service.instructor;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorForAdminDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorNameDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.NewInstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewMapper;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolMapper;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
public class InstructorMapper {

    private SchoolMapper schoolMapper;
    private ReviewMapper reviewMapper;


    public Instructor mapNewInstructorDTOToInstructor(NewInstructorDTO newInstructorDTO, School school) {
        return new Instructor(
                newInstructorDTO.firstName(),
                newInstructorDTO.lastName(),
                school,
                newInstructorDTO.licenseTypeSet());
    }

    public InstructorDTO mapInstructorToInstructorDTO(Instructor instructor) {
        return instructor == null ? null : new InstructorDTO(
                instructor.getPublicId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                schoolMapper.mapSchoolToSchoolNameDTO(instructor.getSchool()),
                mapReviewsToReviewDTOs(instructor.getReviews()),
                instructor.getLicenseType(),
                instructor.getAvgRating()
        );
    }

    public InstructorNameDTO mapInstructorToInstructorNameDTO(Instructor instructor) {
        return instructor == null ? null : new InstructorNameDTO(
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getPublicId(),
                instructor.getLicenseType(),
                instructor.getAvgRating()
        );
    }

    public Set<InstructorNameDTO> mapInstructorsToNameDTOs(Set<Instructor> instructors) {
        return instructors.stream()
                .map(this::mapInstructorToInstructorNameDTO)
                .collect(Collectors.toSet());
    }

    private Set<ReviewDTO> mapReviewsToReviewDTOs(List<Review> reviews) {
        return  reviews.stream()
                .map(reviewMapper::mapReviewToReviewDTO)
                .collect(Collectors.toSet());
    }

    public InstructorForAdminDTO mapInstructorToInstructorForAdminDTO(Instructor instructor) {
        return new InstructorForAdminDTO(
                instructor.getPublicId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                schoolMapper.mapSchoolToSchoolNameDTO(instructor.getSchool())
        );
    }
}
