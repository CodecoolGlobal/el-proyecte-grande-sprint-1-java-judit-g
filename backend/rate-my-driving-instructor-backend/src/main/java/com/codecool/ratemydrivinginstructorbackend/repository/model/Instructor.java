package com.codecool.ratemydrivinginstructorbackend.repository.model;

import java.util.HashSet;
import java.util.Set;

public class Instructor {

    private static final int instructorCount = 0;

    private int id;
    private String firstName;
    private String lastName;
    private Set<Review> reviews;
    private School school;

    public Instructor(String firstName, String lastName, School school) {
        this.id += instructorCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviews = new HashSet<>();
        this.school = school;
    }

    public Instructor(String firstName, String lastName, Set<Review> reviews, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviews = reviews;
        this.school = school;
    }

    private boolean addReview(Review review) {
        return reviews.add(review);
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public School getSchool() {
        return school;
    }
}
