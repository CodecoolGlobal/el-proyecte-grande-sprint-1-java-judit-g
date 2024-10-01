package com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;

import java.util.UUID;

public record ReviewDTO(UUID publicId, String description, int rating, AppUserDTO appUserDTO) {
}
