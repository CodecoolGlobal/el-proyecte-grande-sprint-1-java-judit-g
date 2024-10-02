package com.codecool.ratemydrivinginstructorbackend.controller.admin;

import com.codecool.ratemydrivinginstructorbackend.controller.instructor.instructorDTO.InstructorDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.review.reviewDTO.ReviewDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.NewSchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.controller.school.schoolDTO.SchoolDTO;
import com.codecool.ratemydrivinginstructorbackend.service.appuser.AppUserService;
import com.codecool.ratemydrivinginstructorbackend.service.instructor.InstructorService;
import com.codecool.ratemydrivinginstructorbackend.service.review.ReviewService;
import com.codecool.ratemydrivinginstructorbackend.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AppUserService appUserService;
    private final InstructorService instructorService;
    private final ReviewService reviewService;
    private final SchoolService schoolService;

    @Autowired
    public AdminController(AppUserService appUserService, InstructorService instructorService, ReviewService reviewService, SchoolService schoolService) {
        this.appUserService = appUserService;
        this.instructorService = instructorService;
        this.reviewService = reviewService;
        this.schoolService = schoolService;
    }

    @PutMapping("/instructor/{instructorId}")
    public InstructorDTO updateInstructor(@PathVariable UUID instructorId, @RequestBody InstructorDTO instructor) {
        return instructorService.updateInstructor(instructorId, instructor);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public void deleteInstructor(@PathVariable UUID instructorId) {
        instructorService.deleteInstructor(instructorId);
    }

    @DeleteMapping("/review/{publicId}")
    public void deleteReview(@PathVariable UUID publicId) {
        reviewService.deleteReview(publicId);
    }

    @PutMapping("/review/{publicId}")
    public ReviewDTO updateReview(@PathVariable UUID publicId, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(publicId, reviewDTO);
    }

    @PostMapping("/school")
    public void createSchool(@RequestBody NewSchoolDTO school) {
        schoolService.createSchool(school);
    }

    @PutMapping("/school/{publicId}")
    public void updateSchool(@PathVariable UUID publicId, @RequestBody SchoolDTO school) {
        schoolService.updateSchool(publicId, school);
    }

    @DeleteMapping("/school/{publicId}")
    public void deleteSchool(@PathVariable UUID publicId) {
        schoolService.deleteSchool(publicId);
    }
}
