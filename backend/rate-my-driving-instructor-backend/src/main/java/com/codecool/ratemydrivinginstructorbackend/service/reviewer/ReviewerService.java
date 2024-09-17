package com.codecool.ratemydrivinginstructorbackend.service.reviewer;

import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.JwtResponse;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.ReviewerLoginDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.controller.reviewer.reviewerDTO.NewReviewerDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Role;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.security.jwt.JwtUtils;
import com.codecool.ratemydrivinginstructorbackend.service.reviewer.exception.ReviewerNotFoundException;
import com.codecool.ratemydrivinginstructorbackend.service.school.exception.SchoolNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewerService {

    private final ReviewerRepository reviewerRepository;
    private final ReviewerMapper reviewerMapper;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public ReviewerService(ReviewerRepository reviewerRepository, ReviewerMapper reviewerMapper, JwtUtils jwtUtils, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.reviewerRepository = reviewerRepository;
        this.reviewerMapper = reviewerMapper;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public int countNumberOfReviewers() {
        return (int) reviewerRepository.count();
    }

    public ReviewerDTO createReviewer(NewReviewerDTO newReviewerDTO) {
        Reviewer reviewer = reviewerMapper.mapNewReviewerDTOToReviewer(newReviewerDTO);
        reviewer.addRole(Role.ROLE_USER);
        reviewer.setPassword(passwordEncoder.encode(newReviewerDTO.password()));
        Reviewer savedReviewer = reviewerRepository.save(reviewer);
        return reviewerMapper.mapReviewerToReviewerDTO(savedReviewer);
    }

    public ReviewerDTO findByPublicId(UUID publicId) {
        Reviewer reviewer = reviewerRepository.findByPublicId(publicId).orElseThrow(() -> new ReviewerNotFoundException("Reviewer was not found"));
        return reviewerMapper.mapReviewerToReviewerDTO(reviewer);
    }

    public List<ReviewerDTO> findAll() {
        return reviewerRepository.findAll().stream()
                .map(reviewerMapper::mapReviewerToReviewerDTO)
                .toList();
    }

    public JwtResponse authenticateUser(ReviewerLoginDTO loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();

        return new JwtResponse(jwt, userDetails.getUsername(), roles);
    }

    @Transactional
    public void deleteReviewer(UUID publicId) {
        reviewerRepository.deleteByPublicId(publicId);
    }
}
