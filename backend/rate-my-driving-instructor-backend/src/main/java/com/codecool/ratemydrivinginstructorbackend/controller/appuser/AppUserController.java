package com.codecool.ratemydrivinginstructorbackend.controller.appuser;

import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.JwtResponse;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.NewAppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.appuser.appuserDTO.AppUserLoginDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserService;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorService;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewService;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final InstructorService instructorService;
    private final SchoolService schoolService;
    private final ReviewService reviewService;

    public AppUserController(AppUserService appUserService, InstructorService instructorService, SchoolService schoolService, ReviewService reviewService) {
        this.appUserService = appUserService;
        this.instructorService = instructorService;
        this.schoolService = schoolService;
        this.reviewService = reviewService;
    }

    @PostMapping("/register")
    public AppUserDTO createReviewer(@RequestBody NewAppUserDTO newAppUserDTO) {
        return appUserService.createReviewer(newAppUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateReviewer(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        JwtResponse jwtResponse = appUserService.authenticateUser(appUserLoginDTO);
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

    @GetMapping("/instructor/search")
    public List<InstructorDTO> getInstructorsBySearchWord(@RequestParam String name) {
        System.out.println(name);
        if (name.contains(" ")) {
            String lastName = name.substring(0, name.indexOf(" "));
            String firstName = name.substring(name.indexOf(" ") + 1);
            return instructorService.getInstructorsByFullName(lastName, firstName);
        }
        return instructorService.getInstructorsByName(name, name);
    }

    @GetMapping("/school/search")
    public List<SchoolDTO> getSchoolsBySearchWord(@RequestParam String name) {
        return schoolService.getSchoolsByName(name);
    }

    @GetMapping("/school/count")
    public int getNumberOfSchools() {
        return schoolService.countNumberOfSchools();
    }

    @GetMapping("/review/count")
    public int getNumberOfReviews() {
        return reviewService.countNumberOfReviews();
    }

    @GetMapping("/instructor/count")
    public int getNumberOfInstructors() {
        return instructorService.countNumberOfInstructors();
    }

    @GetMapping("/user/count")
    public int getNumberOfReviewers() {
        return appUserService.countNumberOfReviewers();
    }
}
