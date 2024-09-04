package com.codecool.ratemydrivinginstructorbackend.service.reviewer;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.NewReviewerDTO;
import org.springframework.stereotype.Service;

@Service
public class ReviewerService {

    private final ReviewerRepository reviewerRepository;
    private final ReviewerMapper reviewerMapper;

    public ReviewerService(ReviewerRepository reviewerRepository, ReviewerMapper reviewerMapper) {
        this.reviewerRepository = reviewerRepository;
        this.reviewerMapper = reviewerMapper;
    }

    public ReviewerDTO createReviewer(NewReviewerDTO newReviewerDTO) {
        Reviewer reviewer = reviewerMapper.mapNewReviewerDTOToReviewer(newReviewerDTO);
        Reviewer savedReviewer = reviewerRepository.save(reviewer);
        return reviewerMapper.mapReviewerToReviewerDTO(savedReviewer);
    }
}
