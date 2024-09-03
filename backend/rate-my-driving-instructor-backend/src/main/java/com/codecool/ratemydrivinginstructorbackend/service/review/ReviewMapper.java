package com.codecool.ratemydrivinginstructorbackend.service.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review mapNewReviewDTOtoReview(NewReviewDTO newReviewDTO, Instructor instructor, Reviewer reviewer) {
        return new Review(
                newReviewDTO.description(),
                newReviewDTO.rating(),
                reviewer,
                instructor
        );
    }

    public ReviewDTO mapReviewToReviewDTO(Review review) {
        return new ReviewDTO(
                review.getPublicId(),
                review.getDescription(),
                review.getRating(),
                review.getReviewerPublicId()
        );
    }
}
