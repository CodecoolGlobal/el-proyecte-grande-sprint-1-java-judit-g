package com.codecool.ratemydrivinginstructorbackend.service.reviewservice;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewcontroller.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.instructorrepository.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewrepository.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewerrepository.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.service.reviewservice.exception.ReviewNotCreatedException;
import com.codecool.ratemydrivinginstructorbackend.service.reviewservice.exception.ReviewNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewcontroller.reviewDTO.NewReviewDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final InstructorRepository instructorRepository;
    private final ReviewerRepository reviewerRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, InstructorRepository instructorRepository, ReviewerRepository reviewerRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.instructorRepository = instructorRepository;
        this.reviewerRepository = reviewerRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDTO findReviewByInstructorName(String lastName, String firstName) {
        Optional<Review> optionalReview = reviewRepository.findByInstructorFirstNameAndInstructorLastName(firstName, lastName);
        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review with " + firstName + " and " + lastName + " was not found."));
        return reviewMapper.mapReviewToReviewDTO(review);
    }

    public ReviewDTO createReview(NewReviewDTO newReviewDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findInstructorByPublicId(newReviewDTO.instructorPublicId());
        Optional<Reviewer> optionalReviewer = reviewerRepository.findByPublicId(newReviewDTO.instructorPublicId());

        if (optionalReviewer.isPresent() && optionalInstructor.isPresent()) {
            Review review = reviewMapper.mapNewReviewDTOtoReview(newReviewDTO, optionalInstructor.get(), optionalReviewer.get());
            review.setPublicId(UUID.randomUUID());
            Review newReview = reviewRepository.save(review);
            return reviewMapper.mapReviewToReviewDTO(newReview);
        }
        throw new ReviewNotCreatedException("Reviewer or instructor was not found");
    }

    public void deleteReview(UUID publicId) {
        Optional<Review> optionalReview = reviewRepository.findByPublicId(publicId);
        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review was not found and thus cannot be deleted"));
        reviewRepository.deleteById(review.getPrivateId());
    }

    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        Optional<Review> optionalReview = reviewRepository.findByPublicId(reviewDTO.publicId());

        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review was not found, update failed"));

        review.setDescription(reviewDTO.description());
        review.setRating(reviewDTO.rating());

        return reviewMapper.mapReviewToReviewDTO(review);
    }
}
