package com.codecool.ratemydrivinginstructorbackend;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.review.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.ReviewerRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.SchoolRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer {

    private final ReviewRepository reviewRepository;
    private final SchoolRepository schoolRepository;
    private final ReviewerRepository reviewerRepository;

    @Autowired
    public DataInitializer(ReviewRepository reviewRepository, SchoolRepository schoolRepository, ReviewerRepository reviewerRepository) {
        this.reviewRepository = reviewRepository;
        this.schoolRepository = schoolRepository;
        this.reviewerRepository = reviewerRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
        Reviewer reviewer1 = createInitReviewer("Ádám");
        Reviewer reviewer2 = createInitReviewer("Kata");
        reviewerRepository.saveAll(List.of(reviewer1, reviewer2));

        Review review1 = createInitReview("Türelmes és segítőkész volt", 5);
        Review review2 = createInitReview("Lassú és nem figyelt rám", 2);
        Review review3 = createInitReview("Elégedett vagyok, jó oktató", 4);
        Review review4 = createInitReview("Többet vártam, de nem volt rossz", 3);
        Review review5 = createInitReview("Kimondottan udvarias és profi", 5);
        Review review6 = createInitReview("Túl szigorú volt, de korrekt", 3);
        Review review7 = createInitReview("Nem magyarázott el mindent", 1);
        Review review8 = createInitReview("Kedves és segítőkész, nagyon ajánlom", 5);
        Review review9 = createInitReview("Csak alap dolgokat mondott el", 2);
        Review review10 = createInitReview("Nagyszerű élmény volt, köszönöm!", 5);

        review1.setReviewer(reviewer1);
        review2.setReviewer(reviewer1);
        review3.setReviewer(reviewer1);
        review4.setReviewer(reviewer1);
        review5.setReviewer(reviewer1);
        review6.setReviewer(reviewer2);
        review7.setReviewer(reviewer2);
        review8.setReviewer(reviewer2);
        review9.setReviewer(reviewer2);
        review10.setReviewer(reviewer2);

        reviewer1.setReviews(new ArrayList<>(List.of(review1, review2, review3, review4, review5)));
        reviewer2.setReviews(new ArrayList<>(List.of(review6, review7, review8, review9, review10)));

        reviewRepository.saveAll(List.of(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10));
        reviewerRepository.saveAll(List.of(reviewer1, reviewer2));

        SchoolAddress schoolAddress1 = createInitSchoolAddress("Budapest", "Nagymező", "1", 1111);
        SchoolAddress schoolAddress2 = createInitSchoolAddress("Budapest", "Király", "2", 2222);

        School school1 = createInitSchool("Autós suli1", "+36999999");
        School school2 = createInitSchool("Autós suli2", "+36666666");

        school1.setAddress(schoolAddress1);
        school2.setAddress(schoolAddress2);

        Instructor instructor1 = createInitInstructor("Peter", "Nagy", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        Instructor instructor2 = createInitInstructor("Zoltán", "Szabó", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
        Instructor instructor3 = createInitInstructor("Erika", "Kovács", new HashSet<>(Set.of(LicenseType.B, LicenseType.A2)));
        Instructor instructor4 = createInitInstructor("László", "Varga", new HashSet<>(Set.of(LicenseType.A1, LicenseType.A)));

        instructor1.setSchool(school1);
        instructor2.setSchool(school1);
        instructor3.setSchool(school2);
        instructor4.setSchool(school2);

        school1.setInstructors(new HashSet<>(Set.of(instructor1, instructor2)));
        school2.setInstructors(new HashSet<>(Set.of(instructor3, instructor4)));

        schoolRepository.saveAll(List.of(school1, school2));

        instructor1.setReviews(new HashSet<>(Set.of(review1)));
        instructor2.setReviews(new HashSet<>(Set.of(review2)));
        instructor3.setReviews(new HashSet<>(Set.of(review3)));
        instructor4.setReviews(new HashSet<>(Set.of(review4)));
        instructor1.setReviews(new HashSet<>(Set.of(review5)));
        instructor2.setReviews(new HashSet<>(Set.of(review6)));
        instructor3.setReviews(new HashSet<>(Set.of(review7)));
        instructor4.setReviews(new HashSet<>(Set.of(review8)));
        instructor1.setReviews(new HashSet<>(Set.of(review9)));
        instructor2.setReviews(new HashSet<>(Set.of(review10)));

        review1.setReviewer(reviewer1);
        review2.setReviewer(reviewer1);
        review3.setReviewer(reviewer1);
        review4.setReviewer(reviewer1);
        review5.setReviewer(reviewer1);
        review6.setReviewer(reviewer2);
        review7.setReviewer(reviewer2);
        review8.setReviewer(reviewer2);
        review9.setReviewer(reviewer2);
        review10.setReviewer(reviewer2);

        review1.setInstructor(instructor1);
        review2.setInstructor(instructor2);
        review3.setInstructor(instructor3);
        review4.setInstructor(instructor4);
        review5.setInstructor(instructor1);
        review6.setInstructor(instructor2);
        review7.setInstructor(instructor3);
        review8.setInstructor(instructor4);
        review9.setInstructor(instructor1);
        review10.setInstructor(instructor2);

        reviewRepository.saveAll(List.of(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10));
        schoolRepository.saveAll(List.of(school1, school2));
    }

    private SchoolAddress createInitSchoolAddress(String city, String street, String streetNumber, int zipCode) {
        SchoolAddress schoolAddress = new SchoolAddress();
        schoolAddress.setStreetName(city);
        schoolAddress.setStreetNumber(street);
        schoolAddress.setCity(streetNumber);
        schoolAddress.setPostCode(zipCode);
        return schoolAddress;
    }

    private School createInitSchool(String name, String phoneNumber) {
        School school = new School();
        school.setName(name);
        school.setPhoneNumber(phoneNumber);
        return school;
    }

    private Review createInitReview(String description, int rating) {
        Review review = new Review();
        review.setDescription(description);
        review.setRating(rating);
        return review;
    }

    private Instructor createInitInstructor(String firstName, String lastName, Set<LicenseType> licenses) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setLicenseType(licenses);
        instructor.setReviews(new HashSet<>(Set.of()));
        return instructor;
    }

    private Reviewer createInitReviewer(String name) {
        Reviewer reviewer = new Reviewer();
        reviewer.setName(name);
        return reviewer;
    }
}
