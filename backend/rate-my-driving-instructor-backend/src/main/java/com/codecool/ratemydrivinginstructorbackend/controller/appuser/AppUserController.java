package com.codecool.ratemydrivinginstructorbackend.controller.appuser;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.JwtResponse;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.NewAppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserLoginDTO;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public AppUserDTO createReviewer(@RequestBody NewAppUserDTO newAppUserDTO) {
        return appUserService.createReviewer(newAppUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateReviewer(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        JwtResponse jwtResponse = appUserService.authenticateUser(appUserLoginDTO);
        System.out.println(jwtResponse);
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping
    public List<AppUserDTO> findAll() {
        return appUserService.findAll();
    }

    @GetMapping("/{publicId}")
    public AppUserDTO findByPublicId(@PathVariable UUID publicId) {
        return appUserService.findByPublicId(publicId);
    }

    @DeleteMapping("/{publicId}")
    public void deleteReviewer(@PathVariable UUID publicId) {
        appUserService.deleteReviewer(publicId);
    }

    @GetMapping("/count")
    public int getNumberOfReviewers() {
        return appUserService.countNumberOfReviewers();
    }
}
