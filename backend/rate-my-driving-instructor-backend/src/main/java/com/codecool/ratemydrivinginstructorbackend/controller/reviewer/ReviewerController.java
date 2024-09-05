package com.codecool.ratemydrivinginstructorbackend.controller.reviewer;

import com.codecool.ratemydrivinginstructorbackend.service.reviewer.ReviewerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ReviewerController {

    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }

    @GetMapping("/count")
    public int getNumberOfInstructors() {
        return reviewerService.getNumberOfReviewers();
    }
}
