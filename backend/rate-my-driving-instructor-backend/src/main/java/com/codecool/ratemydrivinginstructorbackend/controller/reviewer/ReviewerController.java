package com.codecool.ratemydrivinginstructorbackend.controller.reviewer;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.JwtResponse;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.NewReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerLoginDTO;
import com.codecool.ratemydrivinginstructorbackend.service.reviewer.ReviewerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class ReviewerController {

    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }

    @PostMapping("/register")
    public ReviewerDTO createReviewer(@RequestBody NewReviewerDTO newReviewerDTO) {
        return reviewerService.createReviewer(newReviewerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateReviewer(@RequestBody ReviewerLoginDTO reviewerLoginDTO) {
        JwtResponse jwtResponse = reviewerService.authenticateUser(reviewerLoginDTO);
        System.out.println(jwtResponse);
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping
    public List<ReviewerDTO> findAll() {
        return reviewerService.findAll();
    }

    @GetMapping("/{publicId}")
    public ReviewerDTO findByPublicId(@PathVariable UUID publicId) {
        return reviewerService.findByPublicId(publicId);
    }

    @DeleteMapping("/{publicId}")
    public void deleteReviewer(@PathVariable UUID publicId) {
        reviewerService.deleteReviewer(publicId);
    }

    @GetMapping("/count")
    public int getNumberOfReviewers() {
        return reviewerService.countNumberOfReviewers();
    }
}
