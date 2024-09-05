package com.codecool.ratemydrivinginstructorbackend.service.reviewer;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.NewReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.service.reviewer.exception.ReviewerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public ReviewerDTO findByPublicId(UUID publicId) {
        Reviewer reviewer = reviewerRepository.findByPublicId(publicId).orElseThrow(() -> new ReviewerNotFoundException("Reviewer was not found"));
        return reviewerMapper.mapReviewerToReviewerDTO(reviewer);
    }

    public List<ReviewerDTO> findAll() {
        return reviewerRepository.findAll().stream()
                .map(reviewerMapper::mapReviewerToReviewerDTO)
                .toList();
    }
}
