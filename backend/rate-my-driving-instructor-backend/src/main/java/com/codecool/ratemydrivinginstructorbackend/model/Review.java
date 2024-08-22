package com.codecool.ratemydrivinginstructorbackend.model;

public class Review {

    private static final int reviewCount = 0;

    private int id;
    private User user;
    private String description;
    private int rating;
    private Instructor instructor;

    public Review(User user, String description, int rating, Instructor instructor) {
        this.id += reviewCount;
        this.user = user;
        this.description = description;
        this.rating = rating;
        this.instructor = instructor;
    }
}
