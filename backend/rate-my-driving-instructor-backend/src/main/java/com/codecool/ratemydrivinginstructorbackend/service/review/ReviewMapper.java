package com.codecool.ratemydrivinginstructorbackend.service.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserMapper;

public class ReviewMapper {

    private final AppUserMapper appUserMapper;

    public ReviewMapper(AppUserMapper appUserMapper) {
        this.appUserMapper = appUserMapper;
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
                appUserMapper.mapAppUserToAppUserDTO(review.getAppUser()));
    }
}
