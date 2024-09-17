package com.codecool.ratemydrivinginstructorbackend.service.reviewer;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.NewReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;

public class ReviewerMapper {

    public Reviewer mapNewReviewerDTOToReviewer(NewReviewerDTO newReviewerDTO) {
        return new Reviewer(
                newReviewerDTO.username()
        );
    }

    public ReviewerDTO mapReviewerToReviewerDTO(Reviewer reviewer) {
        return reviewer == null ? null : new ReviewerDTO(
                reviewer.getPublicId(),
                reviewer.getUsername()
        );
    }
}
