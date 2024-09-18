package com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;

import java.util.UUID;

public record ReviewDTO(UUID publicId, String description, int rating, ReviewerDTO reviewerDTO) {
}
