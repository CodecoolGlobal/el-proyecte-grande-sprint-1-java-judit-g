package com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO;

import java.util.UUID;

public record NewReviewDTO(String description, UUID instructorPublicId, int rating) {

}

