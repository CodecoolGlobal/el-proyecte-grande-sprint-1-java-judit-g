package com.codecool.ratemydrivinginstructorbackend.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Reviewer {

    private static final int userCount = 0;

    @Id
    private Long id;
    private String name;
    private List<Review> reviews;

    public Reviewer(String name) {
        this.id += userCount;
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public Reviewer() {

    }

    public boolean addReview(Review review) {
        return reviews.add(review);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
