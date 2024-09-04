package com.codecool.ratemydrivinginstructorbackend;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.InstructorRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.review.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class DataInitializer {
    private final SchoolRepository schoolRepository;
    private final InstructorRepository instructorRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public DataInitializer(SchoolRepository schoolRepository, InstructorRepository instructorRepository, ReviewRepository reviewRepository) {
        this.schoolRepository = schoolRepository;
        this.instructorRepository = instructorRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void init() {
        SchoolAddress schoolAddress = createInitSchoolAddress();
        School school = createInitSchool();
        school.setAddress(schoolAddress);

        Instructor instructor = createInitInstructor();
        instructor.setSchool(school);

        Review review = createInitReview();

        schoolRepository.save(school);
        instructorRepository.save(instructor);
        reviewRepository.save(review);
    }

    private SchoolAddress createInitSchoolAddress() {
        SchoolAddress schoolAddress = new SchoolAddress();
        schoolAddress.setStreetName("Nagymező");
        schoolAddress.setStreetNumber("12");
        schoolAddress.setCity("Berlin");
        schoolAddress.setPostCode(1111);
        return schoolAddress;
    }

    private School createInitSchool() {
        School school = new School();
        school.setPublicId(UUID.randomUUID());
        school.setName("Dummy school");
        school.setPhoneNumber("1111");
        return school;
    }

    private Review createInitReview() {
        Review review = new Review();
        review.setDescription("Nem volt túl jó");
        review.setRating(5);
        return review;
    }

    private Instructor createInitInstructor() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Jakab");
        instructor.setLastName("Gipsz");
        instructor.setLicenseType(new HashSet<>(Set.of(LicenseType.A, LicenseType.B, LicenseType.A1, LicenseType.A2)));
        instructor.setReviews(new HashSet<>(Set.of()));
        return instructor;
    }
}