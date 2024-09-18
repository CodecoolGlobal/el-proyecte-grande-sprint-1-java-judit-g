package com.codecool.ratemydrivinginstructorbackend.service.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.service.reviewer.ReviewerMapper;

public class ReviewMapper {

    private final ReviewerMapper reviewerMapper;

    public ReviewMapper(ReviewerMapper reviewerMapper) {
        this.reviewerMapper = reviewerMapper;
    }

    public Review mapNewReviewDTOtoReview(NewReviewDTO newReviewDTO, Instructor instructor, Reviewer reviewer) {
        return new Review(
                newReviewDTO.description(),
                newReviewDTO.rating(),
                reviewer,
                instructor
        );
    }

    public ReviewDTO mapReviewToReviewDTO(Review review) {
        return review == null ? null : new ReviewDTO(
                review.getPublicId(),
                review.getDescription(),
                review.getRating(),
                reviewerMapper.mapReviewerToReviewerDTO(review.getReviewer()));
    }
}
