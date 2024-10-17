package com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO;

import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewForAdminDTO;

import java.util.List;
import java.util.UUID;

public record AppUserForAdminDTO(UUID publicId, String username, List<ReviewForAdminDTO> reviews) {
}
