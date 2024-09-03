package com.codecool.ratemydrivinginstructorbackend.service.reviewservice;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewcontroller.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewcontroller.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository.Reviewer;
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
