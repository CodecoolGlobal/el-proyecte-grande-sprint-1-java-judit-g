package com.codecool.ratemydrivinginstructorbackend;

import com.codecool.ratemydrivinginstructorbackend.repository.instructor.Instructor;
import com.codecool.ratemydrivinginstructorbackend.repository.instructor.LicenseType;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.reviewer.Reviewer;
import com.codecool.ratemydrivinginstructorbackend.repository.review.ReviewRepository;
import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress.SchoolAddress;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer {

    private final ReviewRepository reviewRepository;

    @Autowired
    public DataInitializer(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void init() {
//        SchoolAddress schoolAddress1 = createInitSchoolAddress("Budapest", "Nagymező", "1", 1111);
//        SchoolAddress schoolAddress2 = createInitSchoolAddress("Budapest", "Király", "2", 2222);
//        SchoolAddress schoolAddress3 = createInitSchoolAddress("Budapest", "Visegrádi", "3", 3333);
//
//        School school1 = createInitSchool("Autós suli1", "+36999999");
//        School school2 = createInitSchool("Autós suli2", "+36666666");
//        School school3 = createInitSchool("Autós suli3", "+36333333");
//
//        school1.setAddress(schoolAddress1);
//        school2.setAddress(schoolAddress2);
//        school2.setAddress(schoolAddress3);
//
//        Instructor instructor1 = createInitInstructor("Peter", "Nagy", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
//        Instructor instructor2 = createInitInstructor("Zoltán", "Szabó", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
//        Instructor instructor3 = createInitInstructor("Erika", "Kovács", new HashSet<>(Set.of(LicenseType.B, LicenseType.A2)));
//        Instructor instructor4 = createInitInstructor("László", "Varga", new HashSet<>(Set.of(LicenseType.A1, LicenseType.A)));
//        Instructor instructor5 = createInitInstructor("Anita", "Tóth", new HashSet<>(Set.of(LicenseType.A, LicenseType.B)));
//        Instructor instructor6 = createInitInstructor("Gábor", "Horváth", new HashSet<>(Set.of(LicenseType.A, LicenseType.A1, LicenseType.A2)));
//        Instructor instructor7 = createInitInstructor("Eszter", "Kiss", new HashSet<>(Set.of(LicenseType.A1, LicenseType.B)));
//        Instructor instructor8 = createInitInstructor("Tamás", "Molnár", new HashSet<>(Set.of(LicenseType.A, LicenseType.A1, LicenseType.A2)));
//        Instructor instructor9 = createInitInstructor("Judit", "Balogh", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
//        Instructor instructor10 = createInitInstructor("Judit", "Balogh", new HashSet<>(Set.of(LicenseType.B, LicenseType.A1)));
//
//        instructor1.setSchool(school1);
//        instructor2.setSchool(school2);
//        instructor3.setSchool(school2);
//        instructor4.setSchool(school2);
//        instructor5.setSchool(school2);
//        instructor6.setSchool(school2);
//        instructor7.setSchool(school3);
//        instructor8.setSchool(school3);
//        instructor9.setSchool(school3);
//        instructor10.setSchool(school3);
//
//        school1.setInstructors(new HashSet<>(Set.of(instructor1, instructor2, instructor3)));
//        school2.setInstructors(new HashSet<>(Set.of(instructor4, instructor5, instructor6)));
//        school3.setInstructors(new HashSet<>(Set.of(instructor7, instructor8, instructor9, instructor10)));
//
//        Review review1 = createInitReview("Türelmes és segítőkész volt", 5);
//        Review review2 = createInitReview("Lassú és nem figyelt rám", 2);
//        Review review3 = createInitReview("Elégedett vagyok, jó oktató", 4);
//        Review review4 = createInitReview("Többet vártam, de nem volt rossz", 3);
//        Review review5 = createInitReview("Kimondottan udvarias és profi", 5);
//        Review review6 = createInitReview("Túl szigorú volt, de korrekt", 3);
//        Review review7 = createInitReview("Nem magyarázott el mindent", 1);
//        Review review8 = createInitReview("Kedves és segítőkész, nagyon ajánlom", 5);
//        Review review9 = createInitReview("Csak alap dolgokat mondott el", 2);
//        Review review10 = createInitReview("Nagyszerű élmény volt, köszönöm!", 5);
//        Review review11 = createInitReview("Figyelmes és részletes magyarázatok", 5);
//        Review review12 = createInitReview("Sokat késik, nem vagyok elégedett", 1);
//        Review review13 = createInitReview("Megértő és türelmes oktató", 4);
//        Review review14 = createInitReview("Nem figyelt a kérdéseimre", 2);
//        Review review15 = createInitReview("Profi hozzáállás, csak ajánlani tudom", 5);
//        Review review16 = createInitReview("Jobb volt, mint vártam", 4);
//        Review review17 = createInitReview("Gyorsan átvette az anyagot, de nem volt elég alapos", 3);
//        Review review18 = createInitReview("Maximálisan meg voltam elégedve", 5);
//        Review review19 = createInitReview("Nem segített, amikor elakadtam", 2);
//        Review review20 = createInitReview("Nyugodt és tapasztalt oktató", 5);
//
//
//        review1.setInstructor(instructor1);
//        review2.setInstructor(instructor1);
//        review3.setInstructor(instructor1);
//        review4.setInstructor(instructor2);
//        review5.setInstructor(instructor3);
//        review6.setInstructor(instructor4);
//        review7.setInstructor(instructor4);
//        review8.setInstructor(instructor5);
//        review9.setInstructor(instructor5);
//        review10.setInstructor(instructor6);
//        review11.setInstructor(instructor7);
//        review12.setInstructor(instructor7);
//        review13.setInstructor(instructor7);
//        review14.setInstructor(instructor8);
//        review15.setInstructor(instructor8);
//        review16.setInstructor(instructor9);
//        review17.setInstructor(instructor9);
//        review18.setInstructor(instructor10);
//        review19.setInstructor(instructor10);
//        review20.setInstructor(instructor10);
//
//        instructor1.setReviews(new HashSet<>(Set.of(review1, review2, review3)));
//        instructor2.setReviews(new HashSet<>(Set.of(review4)));
//        instructor3.setReviews(new HashSet<>(Set.of(review5)));
//        instructor4.setReviews(new HashSet<>(Set.of(review6, review7)));
//        instructor5.setReviews(new HashSet<>(Set.of(review8, review9)));
//        instructor6.setReviews(new HashSet<>(Set.of(review10)));
//        instructor7.setReviews(new HashSet<>(Set.of(review11, review12, review13)));
//        instructor8.setReviews(new HashSet<>(Set.of(review14, review15)));
//        instructor9.setReviews(new HashSet<>(Set.of(review16, review17)));
//        instructor10.setReviews(new HashSet<>(Set.of(review18, review19, review20)));
//
//        Reviewer reviewer1 = createInitReviewer("Ádám");
//        Reviewer reviewer2 = createInitReviewer("Kata");
//        Reviewer reviewer3 = createInitReviewer("Bence");
//        Reviewer reviewer4 = createInitReviewer("Réka");
//        Reviewer reviewer5 = createInitReviewer("Gergő");
//
//        review1.setReviewer(reviewer1);
//        review2.setReviewer(reviewer1);
//        review3.setReviewer(reviewer1);
//        review4.setReviewer(reviewer1);
//        review5.setReviewer(reviewer2);
//        review6.setReviewer(reviewer2);
//        review7.setReviewer(reviewer2);
//        review8.setReviewer(reviewer2);
//        review9.setReviewer(reviewer3);
//        review10.setReviewer(reviewer3);
//        review11.setReviewer(reviewer3);
//        review12.setReviewer(reviewer3);
//        review13.setReviewer(reviewer4);
//        review14.setReviewer(reviewer4);
//        review15.setReviewer(reviewer4);
//        review16.setReviewer(reviewer4);
//        review17.setReviewer(reviewer5);
//        review18.setReviewer(reviewer5);
//        review19.setReviewer(reviewer5);
//        review20.setReviewer(reviewer5);
//
//        reviewer1.setReviews(new ArrayList<>(List.of(review1, review2, review3, review4)));
//        reviewer2.setReviews(new ArrayList<>(List.of(review5, review6, review7, review8)));
//        reviewer3.setReviews(new ArrayList<>(List.of(review9, review10, review11, review12)));
//        reviewer4.setReviews(new ArrayList<>(List.of(review13, review14, review15, review16)));
//        reviewer5.setReviews(new ArrayList<>(List.of(review17, review18, review19, review20)));
//
//        reviewRepository.saveAll(new ArrayList<>(List.of(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10, review11, review12, review13, review14, review15, review16, review17, review18, review19, review20)));

        SchoolAddress schoolAddress1 = createInitSchoolAddress("Budapest", "Nagymező", "1", 1111);
        School school1 = createInitSchool("Autós suli1", "+36999999");
        school1.setAddress(schoolAddress1);
        Instructor instructor1 = createInitInstructor("Peter", "Nagy", new HashSet<>(Set.of(LicenseType.B, LicenseType.A)));
        instructor1.setSchool(school1);
        school1.setInstructors(new HashSet<>(Set.of(instructor1)));
        Review review1 = createInitReview("Türelmes és segítőkész volt", 5);
        review1.setInstructor(instructor1);
        instructor1.setReviews(new HashSet<>(Set.of(review1)));
        Reviewer reviewer1 = createInitReviewer("Ádám");
        review1.setReviewer(reviewer1);
        reviewer1.setReviews(new ArrayList<>(List.of(review1)));
        reviewRepository.save(review1);
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
