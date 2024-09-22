package com.codecool.ratemydrivinginstructorbackend.repository.instructor;

import com.codecool.ratemydrivinginstructorbackend.repository.school.School;
import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;

    private UUID publicId = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private double avgRating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private School school;

    @ElementCollection(targetClass = LicenseType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "instructor_license_types", joinColumns = @JoinColumn(name = "instructor_id"))
    @Column(name = "license_type")
    private Set<LicenseType> licenseType;

    @JoinColumn(name = "instructor_private_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Review> reviews = new HashSet<>();

    public Instructor(String firstName, String lastName, School school, Set<Review> reviews, Set<LicenseType> licenseType, double avgRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.reviews = new HashSet<>(reviews);
        this.licenseType = new HashSet<>(licenseType);
        this.avgRating = avgRating;
    }

    public Instructor() {}

    public Instructor(String s, String s1, School school, Set<LicenseType> licenseType) {
        this.firstName = s;
        this.lastName = s1;
        this.school = school;
        this.reviews = new HashSet<>();
        this.licenseType = licenseType;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public double getAvgRating() {
        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0);
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<LicenseType> getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Set<LicenseType> licenseType) {
        this.licenseType = licenseType;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
