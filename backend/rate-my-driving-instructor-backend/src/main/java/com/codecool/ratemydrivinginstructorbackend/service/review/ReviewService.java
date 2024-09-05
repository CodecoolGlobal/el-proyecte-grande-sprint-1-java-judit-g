package com.codecool.ratemydrivinginstructorbackend.service.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.review.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.service.review.exception.ReviewNotCreatedException;
import com.codecool.ratemydrivinginstructorbackend.service.review.exception.ReviewNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final InstructorRepository instructorRepository;
    private final ReviewerRepository reviewerRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, InstructorRepository instructorRepository, ReviewerRepository reviewerRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.instructorRepository = instructorRepository;
        this.reviewerRepository = reviewerRepository;
        this.reviewMapper = reviewMapper;
    }

    public int countNumberOfReviews() {
        return (int) reviewRepository.count();
    }

    public ReviewDTO findReviewByInstructorName(String lastName, String firstName) {
        Optional<Review> optionalReview = reviewRepository.findByInstructorFirstNameAndInstructorLastName(firstName, lastName);
        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review with " + firstName + " and " + lastName + " was not found."));
        return reviewMapper.mapReviewToReviewDTO(review);
    }

    public List<ReviewDTO> findAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::mapReviewToReviewDTO)
                .toList();
    }

    public ReviewDTO findByPublicId(UUID publicId) {
        Optional<Review> optionalReview = reviewRepository.findByPublicId(publicId);
        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review was not found by publicId"));
        return reviewMapper.mapReviewToReviewDTO(review);
    }

    public ReviewDTO createReview(NewReviewDTO newReviewDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByPublicId(newReviewDTO.instructorPublicId());
        Optional<Reviewer> optionalReviewer = reviewerRepository.findByPublicId(newReviewDTO.reviewerPublicId());

        if (optionalReviewer.isPresent() && optionalInstructor.isPresent()) {
            Review review = reviewMapper.mapNewReviewDTOtoReview(newReviewDTO, optionalInstructor.get(), optionalReviewer.get());
            Review newReview = reviewRepository.save(review);
            return reviewMapper.mapReviewToReviewDTO(newReview);
        }
        throw new ReviewNotCreatedException("Reviewer or instructor was not found");
    }

    @Transactional
    public void deleteReview(UUID publicId) {
        Optional<Review> optionalReview = reviewRepository.findByPublicId(publicId);
        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review was not found and thus cannot be deleted"));
        reviewRepository.deleteById(review.getPrivateId());
    }

    @Transactional
    public ReviewDTO updateReview(UUID publicId, ReviewDTO reviewDTO) {
        Optional<Review> optionalReview = reviewRepository.findByPublicId(publicId);

        Review review = optionalReview.orElseThrow(() -> new ReviewNotFoundException("Review was not found, update failed"));

        review.setDescription(reviewDTO.description());
        review.setRating(reviewDTO.rating());

        return reviewMapper.mapReviewToReviewDTO(review);
    }
}
