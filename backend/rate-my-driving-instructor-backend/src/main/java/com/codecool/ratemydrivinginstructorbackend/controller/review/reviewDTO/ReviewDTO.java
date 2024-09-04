package com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO;

import java.util.UUID;

//to implement
public record ReviewDTO(UUID publicId, String description, int rating, UUID reviewerPublicId) {
}
