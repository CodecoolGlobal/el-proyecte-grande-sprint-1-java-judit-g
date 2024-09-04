package com.codecool.ratemydrivinginstructorbackend.repository.reviewer;

import com.codecool.ratemydrivinginstructorbackend.repository.review.Review;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Reviewer {

    @Id
    @GeneratedValue
    private long privateId;
    private UUID publicId;
    private String name;

    @OneToMany
    List<Review> reviews;

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

    public void setPrivateId(long privateId) {
        this.privateId = privateId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
