package com.codecool.ratemydrivinginstructorbackend.model;

import java.util.HashSet;
import java.util.Set;

public class Instructor {

    private static final int instructorCount = 0;

    private int id;
    private String firstName;
    private String lastName;
    private Set<Review> reviews;
    private School school;

    public Instructor(int id, String firstName, String lastName, School school) {
        this.id += instructorCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reviews = new HashSet<>();
        this.school = school;
    }

    private boolean addReview(Review review) {
        return reviews.add(review);
    }
}
