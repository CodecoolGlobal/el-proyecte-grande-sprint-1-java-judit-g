package com.codecool.ratemydrivinginstructorbackend.service.appuser;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.JwtResponse;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserLoginDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.AppUser;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.NewAppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.repository.appuser.Role;
import com.codecool.ratemydrivinginstructorbackend.security.jwt.JwtUtils;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.exception.AppUserNotFoundException;
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
import java.util.UUID;

@Service
public class AppUserService {

    private final ReviewerRepository reviewerRepository;
    private final AppUserMapper appUserMapper;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AppUserService(ReviewerRepository reviewerRepository, AppUserMapper appUserMapper, JwtUtils jwtUtils, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.reviewerRepository = reviewerRepository;
        this.appUserMapper = appUserMapper;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public int countNumberOfReviewers() {
        return (int) reviewerRepository.count();
    }

    public AppUserDTO createReviewer(NewAppUserDTO newAppUserDTO) {
        AppUser appUser = appUserMapper.mapNewAppUserDTOToAppUser(newAppUserDTO);
        appUser.addRole(Role.ROLE_USER);
        appUser.setPassword(passwordEncoder.encode(newAppUserDTO.password()));
        AppUser savedAppUser = reviewerRepository.save(appUser);
        return appUserMapper.mapAppUserToAppUserDTO(savedAppUser);
    }

    public AppUserDTO findByPublicId(UUID publicId) {
        AppUser appUser = reviewerRepository.findByPublicId(publicId).orElseThrow(() -> new AppUserNotFoundException("Reviewer was not found"));
        return appUserMapper.mapAppUserToAppUserDTO(appUser);
    }

    public List<AppUserDTO> findAll() {
        return reviewerRepository.findAll().stream()
                .map(appUserMapper::mapAppUserToAppUserDTO)
                .toList();
    }

    public JwtResponse authenticateUser(AppUserLoginDTO loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();

        AppUser appUser = reviewerRepository.findUserByUsername(loginRequest.username()).orElseThrow(() -> new AppUserNotFoundException("Reviewer not found"));

        return new JwtResponse(jwt, userDetails.getUsername(), roles, appUser.getPublicId());
    }

    @Transactional
    public void deleteReviewer(UUID publicId) {
        reviewerRepository.deleteByPublicId(publicId);
    }
}
