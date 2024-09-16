package com.codecool.ratemydrivinginstructorbackend.controller.review;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.NewReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewService;
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

    @GetMapping("/count")
    public int getNumberOfReviews() {
        return reviewService.countNumberOfReviews();
    }

    @GetMapping
    public List<ReviewDTO> findAllReviews() {
        return reviewService.findAllReviews();
    }

    @GetMapping("/{publicId}")
    public ReviewDTO findByPublicId(@PathVariable UUID publicId) {
        return reviewService.findByPublicId(publicId);
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody NewReviewDTO newReviewDTO) {
        return reviewService.createReview(newReviewDTO);
    }

    @DeleteMapping("/{publicId}")
    public void deleteReview(@PathVariable UUID publicId) {
        reviewService.deleteReview(publicId);
    }

    @PutMapping("/{publicId}")
    public ReviewDTO updateReview(@PathVariable UUID publicId, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(publicId, reviewDTO);
    }
}
