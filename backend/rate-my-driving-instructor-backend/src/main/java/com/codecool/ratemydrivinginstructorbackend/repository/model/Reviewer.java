package com.codecool.ratemydrivinginstructorbackend.repository.model;

import java.util.ArrayList;
import java.util.List;

public class Reviewer {

    private static final int userCount = 0;

    private int id;
    private String name;
    private List<Review> reviews;

    public Reviewer(String name) {
        this.id += userCount;
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public boolean addReview(Review review) {
        return reviews.add(review);
    }
}
