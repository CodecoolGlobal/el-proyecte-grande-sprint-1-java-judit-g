package com.codecool.ratemydrivinginstructorbackend.repository.model;

public class Review {

    private static final int reviewCount = 0;

    private int id;
    private Reviewer reviewer;
    private String description;
    private int rating;
    private Instructor instructor;

    public Review(Reviewer reviewer, String description, int rating, Instructor instructor) {
        this.id += reviewCount;
        this.reviewer = reviewer;
        this.description = description;
        this.rating = rating;
        this.instructor = instructor;
    }
}
