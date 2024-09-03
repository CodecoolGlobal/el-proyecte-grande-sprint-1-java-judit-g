package com.codecool.ratemydrivinginstructorbackend.repository.model.instructor;

import com.codecool.ratemydrivinginstructorbackend.repository.model.Review;
import com.codecool.ratemydrivinginstructorbackend.repository.model.School;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class InstructorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private School school;


    @ElementCollection(targetClass = LicenseType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "instructor_license_types", joinColumns = @JoinColumn(name = "instructor_id"))
    @Column(name = "license_type")
    private Set<LicenseType> licenseType;
    @OneToMany
    private Set<Review> reviews;


    public InstructorEntity(String firstName, String lastName, School school, Set<Review> reviews, Set<LicenseType> licenseType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.reviews = reviews;
        this.licenseType = licenseType;
    }

    public InstructorEntity() {

    }

    public InstructorEntity(String s, String s1, School school, Set<LicenseType> licenseType) {
        this.firstName = s;
        this.lastName = s1;
        this.school = school;
        this.reviews = new HashSet<>();
        this.licenseType = licenseType;
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
}
