package com.codecool.ratemydrivinginstructorbackend.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {

    private static final int reviewCount = 0;

    @Id
    private Long id;
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

    public Review() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
