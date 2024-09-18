package com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO;

import java.util.List;
import java.util.UUID;

public record JwtResponse(String jwt, String username, List<String> role, UUID publicId) {
}
