package com.codecool.ratemydrivinginstructorbackend.service.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewForAdminDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserMapper;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorMapper;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReviewMapper {

    private AppUserMapper appUserMapper;
    private InstructorMapper instructorMapper;

    public ReviewMapper(AppUserMapper appUserMapper, InstructorMapper instructorMapper) {
        this.appUserMapper = appUserMapper;
        this.instructorMapper = instructorMapper;
    }

    public Review mapNewReviewDTOtoReview(NewReviewDTO newReviewDTO, Instructor instructor, AppUser appUser) {
        return new Review(
                newReviewDTO.description(),
                newReviewDTO.rating(),
                appUser,
                instructor
        );
    }

    public ReviewDTO mapReviewToReviewDTO(Review review) {
        return review == null ? null : new ReviewDTO(
                review.getPublicId(),
                review.getDescription(),
                review.getRating(),
                review.getPublishingTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                appUserMapper.mapAppUserToAppUserDTO(review.getAppUser()));
    }

    private ReviewForAdminDTO mapReviewToReviewForAdminDTO(Review review) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a z");
        return new ReviewForAdminDTO(
                review.getPublicId(),
                review.getDescription(),
                review.getRating(),
                review.getPublishingTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                instructorMapper.mapInstructorToInstructorForAdminDTO(review.getInstructor()));
    }

    public List<ReviewForAdminDTO> mapReviewsToReviewForAdminDTO(List<Review> reviews) {
        return reviews.stream()
                .map(review -> mapReviewToReviewForAdminDTO(review))
                .toList();
    }
}
