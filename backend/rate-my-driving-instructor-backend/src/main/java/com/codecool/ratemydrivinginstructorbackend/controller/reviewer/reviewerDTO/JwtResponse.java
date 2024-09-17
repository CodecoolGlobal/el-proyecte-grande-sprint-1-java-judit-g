package com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO;

import java.util.List;

public record JwtResponse(String jwt, String userName, List<String> role) {
}
