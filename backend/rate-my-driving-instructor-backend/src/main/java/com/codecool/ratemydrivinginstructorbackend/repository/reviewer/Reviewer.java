package com.codecool.ratemydrivinginstructorbackend.repository.reviewer;

import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long privateId;

    private UUID publicId = UUID.randomUUID();

    private String name;

    @OneToMany
    List<Review> reviews;

    public Reviewer() {

    }

    public Reviewer(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public long getPrivateId() {
        return privateId;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
