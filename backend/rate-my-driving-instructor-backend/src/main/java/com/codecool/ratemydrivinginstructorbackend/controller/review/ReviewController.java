package com.codecool.ratemydrivinginstructorbackend.controller.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/instructor")
    public ReviewDTO findReviewByInstructorName(@RequestParam String firstName, @RequestParam String lastName) {
        return reviewService.findReviewByInstructorName(lastName, firstName);
    }

    @GetMapping
    public List<ReviewDTO> findAllReviews() {
        return reviewService.findAllReviews();
    }

    @GetMapping("/{publicId}")
    public ReviewDTO findByPublicId(@PathVariable UUID publicId) {
        return reviewService.findByPublicId(publicId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ReviewDTO createReview(@RequestBody NewReviewDTO newReviewDTO) {
        return reviewService.createReview(newReviewDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{publicId}")
    public void deleteReview(@PathVariable UUID publicId) {
        reviewService.deleteReview(publicId);
    }

}
