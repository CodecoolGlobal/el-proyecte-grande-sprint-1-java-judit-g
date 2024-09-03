package com.codecool.ratemydrivinginstructorbackend.controller.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ReviewDTO createReview(@RequestBody NewReviewDTO newReviewDTO) {
        return reviewService.createReview(newReviewDTO);
    }

    @DeleteMapping("/{publicId}")
    public void deleteReview(@PathVariable UUID publicId) {
        reviewService.deleteReview(publicId);
    }

    @PutMapping
    public ReviewDTO updateReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(reviewDTO);
    }
}
